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
	 * ��ӿ�Ŀ�����ǰ�жϿ�Ŀ�Ƿ���ڣ������ڲŲ������� 
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
				System.out.println("��ӿγ�ʱ��SQL��" + sql);
				conn.close();
			}
		} catch (Exception ex) {
			falg = 0;
		}
		return falg;
	}
	
	/*
	 *  �޸Ŀ�Ŀ��Ϣ
	 */
	public int update(LessonForm lessonForm) {
		String sql = "UPDATE courseinfo SET name='" + lessonForm.getName() + "' where id=" + lessonForm.getID() + "";
		int ret = conn.executeUpdate(sql);
		System.out.println("�޸Ŀ�Ŀʱ��SQL��" + sql);
		System.out.println("ret="+ret);
		conn.close();
		return ret;
	}

	/*
	 * ��ѯ��Ŀ����
	 */
	public List query(int id) {
		List lessonList = new ArrayList();
		LessonForm lessonForm1 = null;
		String sql = "";
		if (id == 0) {
			// ��ѯȫ����Ŀ�����Ұ������ʱ��Ľ�������
			//sql = "SELECT id,NAME,JoinTime,(@row := @row +1) xuhao FROM courseinfo,( SELECT @row :=0)r ORDER BY joinTime DESC";
			sql = "SELECT id,NAME,JoinTime FROM courseinfo ORDER BY joinTime DESC";
		} else if (id == -1) {
			// ��ѯ�����Ծ�Ŀ�Ŀ��ʹ�������ӣ���Ŀ���²�һ�����Ծ�  
			//INNER JOIN ����
			//����������еļ�¼��ֻҪ�ڹ����ֶ�֮���������ֵ��
			sql = "SELECT distinct l.* FROM courseinfo l INNER JOIN testpaperinfo t ON l.id=t.LessonId";
			
			/*  
			 * ���ݿ�������Ӻ������ӵ�����
				  ������
				A(id,name)
				���ݣ�(1,����)(2,����)(3,����)
				B(id,name)
				���ݣ�(1,ѧ��)(2,��ʦ)(4,У��)
				
				�����ӽ����
				select A.*,B.* from A left join B on A.id=B.id;
				1 ���� 1    ѧ��
				2 ���� 2    ��ʦ
				3 ���� NULL NULL
				
				�����ӽ����
				select A.*,B.* from A right join B on A.id=B.id;
				1    ���� 1 ѧ��
				2    ���� 2 ��ʦ
				NULL NULL 4 У��
				
				****************
				���䣺������������ͻ��õ�������
				������������һ�����û���һ���ǽ��׼�¼�������Ҫ��ѯÿ���û��Ľ��׼�¼��Ҫ�õ����������ӣ���Ϊ����ÿ���û����н��׼�¼��
				�õ��������Ӻ��н��׼�¼����Ϣ�ͻ���ʾ��û�еľ���ʾNULL�����������Ҿٵ�����һ����
				������������ӵĻ������硾���塿û�н��׼�¼�Ļ�����ô�û�����ġ����塿����Ϣ�Ͳ�����ʾ����ʧȥ�˲�ѯ�����û����׼�¼�������ˡ�
				****************
				* 
			 */
			
		} else if (id == -2) { 
			// ��ѯ����������Ŀ�Ŀ�Ŀ
			sql = "SELECT distinct l.* FROM courseinfo l INNER JOIN questionsinfo q ON l.id=q.LessonId " +
					"WHERE name not in (SELECT distinct whichLesson FROM examineescore)";
		} else {
			sql = "SELECT * FROM courseinfo WHERE id=" + id + "";
		}
		System.out.println("��ѯ����������Ŀ�Ŀγ̣�" + sql);
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
	 * ���ݿ�����׼��֤��ѯ�������Կ�Ŀ 
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
	 *  ɾ����Ŀ���ݣ��h��ǰ�жϣ����ɾ����Ŀ����Ŀ�����������Ŀ����Ծ�Ϳ�����Ŀһ��ɾ��
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

