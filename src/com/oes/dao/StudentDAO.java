package com.oes.dao;

import com.oes.actionForm.StudentForm;
import com.oes.core.ChStr;
import com.oes.core.ConnDB;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.NumberFormat;

public class StudentDAO {
	private ConnDB conn = new ConnDB();
	private ChStr chStr = new ChStr();

	/*
	 *  考生身份验证，获取记录条数，表示考生考了多少门科目
	 */
	public int checkStudent(StudentForm studentForm) {
		int flag = 1;
		String sql = "SELECT * FROM examineeinfo where ID='" + studentForm.getID() + "'";
		ResultSet rs = conn.executeQuery(sql);
		try {
			if (rs.next()) {
				String pwd = studentForm.getPwd();
				if (pwd.equals(rs.getString(3))) {
					rs.last();
					int rowSum = rs.getRow(); // 获取记录总数
					rs.first();
					if (rowSum != 1) {
						flag = 2;
						System.out.print("获取row的值：" + sql +"  "+ rowSum);
					}
				} else {
					flag = 2;
				}
			} else {
				flag = 2;
			}
		} catch (Exception ex) {
			flag = 2;
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	/*
	 *  添加考生信息，根据学号判断考生是否注册，如果学号已经存在，提示考生已经注册过，可以直接登录
	 */
	public String insert(StudentForm s) {
		String sql1 = "SELECT * FROM examineeinfo WHERE cardNo='" + s.getCardNo() + "'";
		System.out.println("考生学号为："+s.getCardNo());
		ResultSet rs = conn.executeQuery(sql1); // 执行SQL查询语句
		String sql = "";
		String falg = "miss"; // 用于记录返回信息的变量
		String ID = "";
		try {
			if (rs.next()) { // 假如存在记录
				falg = "re"; // 表示考生信息已经注册
			} else {
				/***************** 自动生成准考证号 ***********************************************/
				String sql_max = "SELECT max(ID) FROM examineeinfo";
				ResultSet rs_max = conn.executeQuery(sql_max); // 查询最大的准考证号
				java.util.Date date = new java.util.Date(); // 实例化java.util.Date()类
				String newTime = new SimpleDateFormat("yyyyMMdd").format(date); // 格式化当前日期
				if (rs_max.next()) {
					String max_ID = rs_max.getString(1); // 获取最大的准考证号
					int newId = Integer.parseInt(max_ID.substring(12, 16)) + 1;// 取出最大准考证号中的数字编号+1
					String no = chStr.formatNO(newId, 4); // 将生成的编号格式化为4位
					ID = "GDOU" + newTime + no; // 组合完整的准考证号
				} else { // 当第一个考生注册时
					ID = "GDOU" + newTime + "0001"; // 生成第一个准考证号
				}
                	/********************************************************************************/
              		sql = "INSERT INTO examineeinfo (ID,name,pwd,sex,joinTime,question,answer,profession,cardNo) values('" +
                                 ID+ "','" +s.getName() +"','"+s.getPwd()+"','"+s.getSex()+"',now(),'"+s.getQuestion()+
                                 "','"+s.getAnswer()+"','"+s.getProfession()+"','"+s.getCardNo()+"')";
				int ret = conn.executeUpdate(sql); // 保存考生注册信息
				if (ret == 0) {
					falg = "miss"; // 表示考生注册失败
				} else {
					falg = "恭喜您，注册成功!\\r请牢记您的准考证号：" + ID; // 返回生成的准考证号
					System.out.println("考生注册成功时的准考证号为：" + ID);
				}
				conn.close(); // 关闭数据库连接
			}
		} catch (Exception e) {
			falg = "miss";
			System.out.println("添加考生信息时的错误信息：" + e.getMessage()); // 输出错误提示信息到控制台
		}
		return falg;
	}

	/*
	 *  查询考生信息
	 */
	public List query(String id) {
		List studentList = new ArrayList();
		StudentForm studentForm1 = null;
		String sql = "";
		if (id == null || id.equals("")) {
			sql = "SELECT * FROM examineeinfo ORDER BY joinTime DESC";
		} else {
			sql = "SELECT * FROM examineeinfo WHERE id='" + id + "'";
		}
		ResultSet rs = conn.executeQuery(sql);
		try {
			while (rs.next()) {
				studentForm1 = new StudentForm();
				studentForm1.setID(rs.getString(1));
				studentForm1.setName(rs.getString(2));
				studentForm1.setPwd(rs.getString(3));
				studentForm1.setSex(rs.getString(4));
				studentForm1.setJoinTime(java.text.DateFormat
						.getDateTimeInstance().parse(rs.getString(5)));
				studentForm1.setQuestion(rs.getString(6));
				studentForm1.setAnswer(rs.getString(7));
				studentForm1.setProfession(rs.getString(8));
				studentForm1.setCardNo(rs.getString(9));
				studentList.add(studentForm1);
			}
		} catch (Exception ex) {
		}
		return studentList;
	}

	/*
	 *  修改考生资料
	 */
	public int update(StudentForm s) {
		String sql = "UPDATE examineeinfo SET pwd='" + s.getPwd() + "',sex='"
				+ s.getSex() + "',question='" + s.getQuestion() + "',answer='"
				+ s.getAnswer() + "',profession='" + s.getProfession()
				+ "' where ID='" + s.getID() + "'";
		int ret = conn.executeUpdate(sql);
		System.out.println("修改考生资料时的SQL：" + sql);
		conn.close();
		return ret;
	}

	/*
	 *  考生找回密码（第一步），输入学号查找信息
	 */
	public StudentForm seekPwd1(StudentForm s) {
		String sql = "SELECT * FROM examineeinfo WHERE cardNo='" + s.getCardNo() + "'";
		ResultSet rs = conn.executeQuery(sql);
		try {
			if (rs.next()) {
				s.setCardNo(rs.getString(9));
				s.setQuestion(rs.getString(6));
			} else {
				s.setCardNo("");
			}
		} catch (Exception e) {
			System.out.println("找回准考证或密码（第一步）出现的错误信息：" + e.getMessage());
		}
		return s;
	}

	/*
	 *  考生找回密码（第二步），输入提示问题答案
	 */
	public StudentForm seekPwd2(StudentForm s) {
		String sql = "SELECT * FROM examineeinfo WHERE cardNo='" + s.getCardNo() + "'";
		System.out.println("SQL" + sql);
		ResultSet rs = conn.executeQuery(sql);
		try {
			if (rs.next()) {
				String ID = rs.getString(1);
				String cardNo = rs.getString(9);
				String pwd = rs.getString(3);
				String answer = rs.getString(7);
				if (answer.equals(s.getAnswer())) {
					s.setID(ID);
					s.setPwd(pwd);
				} else {
					s.setCardNo("");
				}
			}
		} catch (Exception e) {
			System.out.println("找回准考证或密码（第二步）出现的错误信息：" + e.getMessage());
		}
		return s;
	}

	/*
	 *  删除考生信息,删除时判断该考生是否有考试成绩，有的一并删除
	 */
	public int delete(StudentForm studentForm) {
		int flag = 0;
		String[] delId = studentForm.getDelIdArray();
		if (delId.length > 0) {
			String id = "'";
			for (int i = 0; i < delId.length; i++) {
				id = id + delId[i] + "','";
			}
			id = id.substring(0, id.length() - 2);
			String sql = "DELETE FROM examineeinfo where id in (" + id + ")";
			System.out.println("删除时的SQL：" + sql);
			flag = conn.executeUpdate(sql);
			String sql3 = "SELECT count(*) FROM examineescore where stuId in (" + id + ")";
			ResultSet rs1 = conn.executeQuery(sql3);
			try {
				rs1.next();
				if (!rs1.getString(1).equals("0")) {
					String sql4 = "DELETE FROM examineescore where stuId in (" + id + ")";
					flag = conn.executeUpdate(sql4);
					System.out.println("删除时的SQL：" + sql4);
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
