package com.oes.dao;

import com.oes.actionForm.TaoTiForm;
import com.oes.core.ConnDB;

import java.sql.*;
import java.util.*;

public class TaoTiDAO {
	private ConnDB conn = new ConnDB();

	/*
	 *  ��ӿ����Ծ����ǰ�ж��Ծ��Ƿ���ڣ������ڲ��ܲ�������
	 */
	public int insert(TaoTiForm taoTiForm) {
		String sql1 = "SELECT * FROM testpaperinfo WHERE name='"
				+ taoTiForm.getName() + "' AND lessonId="
				+ taoTiForm.getLessonId() + "";
		ResultSet rs = conn.executeQuery(sql1);
		String sql = "";
		int falg = 0;
		try {
			if (rs.next()) {
				falg = 2;
			} else {
				sql = "INSERT INTO testpaperinfo (id,name,lessonId,joinTime) values(null,'"
						+ taoTiForm.getName()
						+ "',"
						+ taoTiForm.getLessonId()
						+ ",now())";
				falg = conn.executeUpdate(sql);
				System.out.println("�������ʱ��SQL��" + sql);
				conn.close();
			}
		} catch (Exception ex) {
			falg = 0;
		}
		return falg;
	}

	/*
	 * ��ѯ�����Ծ�
	 */
	public List query(int id) {
		List taoTiList = new ArrayList();
		TaoTiForm taoTiForm1 = null;
		String sql = "";
		if (id == 0) {
			sql = "SELECT * FROM testpaperinfo ORDER BY lessonId DESC";
		} else {
			sql = "SELECT * FROM testpaperinfo WHERE id=" + id + "";
		}
		ResultSet rs = conn.executeQuery(sql);
		try {
			while (rs.next()) {
				taoTiForm1 = new TaoTiForm();
				taoTiForm1.setID(rs.getInt(1));
				taoTiForm1.setName(rs.getString(2));
				taoTiForm1.setLessonId(rs.getInt(3));
				taoTiForm1.setJoinTime(java.text.DateFormat
						.getDateTimeInstance().parse(rs.getString(4)));
				taoTiList.add(taoTiForm1);
			}
		} catch (Exception ex) {
		}
		return taoTiList;
	}

	/*
	 *  ���ݿ�ĿID��ѯ�����Ծ�
	 */
	public List queryTaoTi(int lessonId) {
		List taoTiList = new ArrayList();
		TaoTiForm taoTiForm1 = null;
		String sql = "SELECT * FROM testpaperinfo WHERE lessonId=" + lessonId + "";
		System.out.println("���ݿ�ĿID��ѯ�����Ծ�SQL:" + sql);
		ResultSet rs = conn.executeQuery(sql);
		try {
			while (rs.next()) {
				taoTiForm1 = new TaoTiForm();
				taoTiForm1.setID(rs.getInt(1));
				taoTiForm1.setName(rs.getString(2));
				taoTiForm1.setLessonId(rs.getInt(3));
				taoTiForm1.setJoinTime(java.text.DateFormat
						.getDateTimeInstance().parse(rs.getString(4)));
				taoTiList.add(taoTiForm1);
			}
		} catch (Exception ex) {
		}
		return taoTiList;
	}

	/*
	 *  �޸Ŀ����Ծ���Ϣ
	 */
	public int update(TaoTiForm taoTiForm) {
		String sql = "UPDATE testpaperinfo SET name='" + taoTiForm.getName()
				+ "',lessonId=" + taoTiForm.getLessonId() + " where id="
				+ taoTiForm.getID() + "";
		int ret = conn.executeUpdate(sql);
		System.out.println("�޸�����ʱ��SQL��" + sql);
		conn.close();
		return ret;
	}

	/*
	 *  ����������Ŀ��ѯ��Ŀ����
	 */
	public String getLesson(int id) {
		String lessonName = "";
		if (id > 0) {
			String sql = "SELECT * FROM courseinfo WHERE id=" + id + "";
			ResultSet rs = conn.executeQuery(sql);
			try {
				if (rs.next()) {
					lessonName = rs.getString(2);
				}
			} catch (Exception ex) {
			}
		}
		return lessonName;
	}

	/*
	 *  ɾ�������Ծ���Ϣ��ɾ��֮ǰ�жϿ����Ծ������Ƿ��п�����Ŀ�������һ��ɾ��
	 */
	public int delete(TaoTiForm taoTiForm) {
		int flag = 0;
		String[] delId = taoTiForm.getDelIdArray();
		if (delId.length > 0) {
			String id = "";
			for (int i = 0; i < delId.length; i++) {
				id = id + delId[i] + ",";
			}
			id = id.substring(0, id.length() - 1);
			String sql = "DELETE FROM testpaperinfo where id in (" + id + ")";
			flag = conn.executeUpdate(sql);
			String sql3 = "SELECT count(*) FROM questionsinfo where taoTiID in (" + id + ")";
			ResultSet rs1 = conn.executeQuery(sql3);
			try {
				rs1.next();
				if (!rs1.getString(1).equals("0")) {
					String sql4 = "DELETE FROM questionsinfo where taoTiID in (" + id + ")";
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
