package com.oes.dao;

import com.oes.actionForm.LessonForm;
import com.oes.actionForm.TaoTiForm;
import com.oes.core.ConnDB;
import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpSession;

public class LessonDAO {
	private ConnDB conn = new ConnDB();

	/*
	 * 添加科目，添加前判断科目是否存在，不存在才插入数据 
	 */
	public int insert(LessonForm lessonForm) {
		String sql1 = "SELECT * FROM courseinfo WHERE name='" + lessonForm.getName() + "'";
		ResultSet rs = conn.executeQuery(sql1);
		String sql = "";
		int falg = 0;
		try {
			if (rs.next()) {
				falg = 2;
			} else {
				sql = "INSERT INTO courseinfo values(null,'" + lessonForm.getName() + "',now())";
				falg = conn.executeUpdate(sql);
				System.out.println("添加课程时的SQL：" + sql);
				conn.close();
			}
		} catch (Exception ex) {
			falg = 0;
		}
		return falg;
	}
	
	/*
	 *  修改科目信息
	 */
	public int update(LessonForm lessonForm) {
		String sql = "UPDATE courseinfo SET name='" + lessonForm.getName() + "' where id=" + lessonForm.getID() + "";
		int ret = conn.executeUpdate(sql);
		System.out.println("修改科目时的SQL：" + sql);
		System.out.println("ret="+ret);
		conn.close();
		return ret;
	}

	/*
	 * 查询科目方法
	 */
	public List query(int id) {
		List lessonList = new ArrayList();
		LessonForm lessonForm1 = null;
		String sql = "";
		if (id == 0) {
			// 查询全部科目，并且按照添加时间的降序排列
			//sql = "SELECT id,NAME,JoinTime,(@row := @row +1) xuhao FROM courseinfo,( SELECT @row :=0)r ORDER BY joinTime DESC";
			sql = "SELECT id,NAME,JoinTime FROM courseinfo ORDER BY joinTime DESC";
		} else if (id == -1) {
			// 查询包括试卷的科目，使用左连接，科目旗下不一定有试卷  
			//INNER JOIN 运算
			//组合两个表中的记录，只要在公共字段之中有相符的值。
			sql = "SELECT distinct l.* FROM courseinfo l INNER JOIN testpaperinfo t ON l.id=t.LessonId";
			
			/*  
			 * 数据库表左连接和右连接的区别
				  两个表：
				A(id,name)
				数据：(1,张三)(2,李四)(3,王五)
				B(id,name)
				数据：(1,学生)(2,老师)(4,校长)
				
				左连接结果：
				select A.*,B.* from A left join B on A.id=B.id;
				1 张三 1    学生
				2 李四 2    老师
				3 王五 NULL NULL
				
				右链接结果：
				select A.*,B.* from A right join B on A.id=B.id;
				1    张三 1 学生
				2    李四 2 老师
				NULL NULL 4 校长
				
				****************
				补充：下面这种情况就会用到外连接
				比如有两个表一个是用户表，一个是交易记录表，如果我要查询每个用户的交易记录就要用到左外外连接，因为不是每个用户都有交易记录。
				用到左外连接后，有交易记录的信息就会显示，没有的就显示NULL，就像上面我举得例子一样。
				如果不用外连接的话，比如【王五】没有交易记录的话，那么用户表里的【王五】的信息就不会显示，就失去了查询所有用户交易记录的意义了。
				****************
				* 
			 */
			
		} else if (id == -2) { 
			// 查询包括考试题目的科目
			sql = "SELECT distinct l.* FROM courseinfo l INNER JOIN questionsinfo q ON l.id=q.LessonId " +
					"WHERE name not in (SELECT distinct whichLesson FROM examineescore)";
		} else {
			sql = "SELECT * FROM courseinfo WHERE id=" + id + "";
		}
		System.out.println("查询包括考试题目的课程：" + sql);
		ResultSet rs = conn.executeQuery(sql);
		try {
			while (rs.next()) {
				lessonForm1 = new LessonForm();
				lessonForm1.setID(rs.getInt(1));
				lessonForm1.setName(rs.getString(2));
				lessonForm1.setJoinTime(java.text.DateFormat
						.getDateTimeInstance().parse(rs.getString(3)));
			//	lessonForm1.setXuhao(rs.getInt(4));
				lessonList.add(lessonForm1);
			}
		} catch (Exception ex) {
		}
		return lessonList;
	}

	/*
	 * 根据考生的准考证查询考生考试科目 
	 */
	public List query(String studentID) {
		List lessonList = new ArrayList();
		LessonForm lessonForm1 = null;
		String sql = "SELECT * FROM courseinfo WHERE ID in(SELECT distinct lessonID FROM "
				+ "(SELECT lessonId,taoTiID FROM questionsinfo GROUP BY taoTiID,lessonID,type)"
				+ " as lessonTaoTi GROUP BY lessonId,taoTiID HAVING COUNT(taoTiID) >1) AND"
				+ " name not in (SELECT distinct whichLesson FROM examineescore WHERE stuId='"
				+ studentID + "')";		
		ResultSet rs = conn.executeQuery(sql);
		try {
			while (rs.next()) {
				lessonForm1 = new LessonForm();
				lessonForm1.setID(rs.getInt(1));
				lessonForm1.setName(rs.getString(2));
				lessonList.add(lessonForm1);
			}
		} catch (Exception ex) {
		}
		return lessonList;
	}

	/*
	 *  删除科目数据，刪除前判断，如果删除科目，科目旗下所附带的考试试卷和考试题目一并删除
	 */
	public int delete(LessonForm lessonForm) {
		int flag = 0;
		String[] delId = lessonForm.getDelIdArray();
		if (delId.length > 0) {
			String id = "";
			for (int i = 0; i < delId.length; i++) {
				id = id + delId[i] + ",";
			}
			id = id.substring(0, id.length() - 1);
			String sql = "DELETE FROM courseinfo where id in (" + id + ")";
			flag = conn.executeUpdate(sql);
			String sql1 = "SELECT count(*) FROM testpaperinfo where lessonId in (" + id + ")";
			ResultSet rs = conn.executeQuery(sql1);
			try {
				rs.next();
				if (!rs.getString(1).equals("0")) {
					String sql2 = "DELETE FROM testpaperinfo where lessonId in (" + id + ")";
					flag = conn.executeUpdate(sql2);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String sql3 = "SELECT count(*) FROM questionsinfo where lessonId in (" + id + ")";
			ResultSet rs1 = conn.executeQuery(sql3);
			try {
				rs1.next();
				if (!rs1.getString(1).equals("0")) {
					String sql4 = "DELETE FROM questionsinfo where lessonId in (" + id + ")";
					flag = conn.executeUpdate(sql4);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn.close();
		} else {
			flag = 0;
		}
		return flag;
	}
}

