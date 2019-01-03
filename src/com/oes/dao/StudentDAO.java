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
	 *  ���������֤����ȡ��¼��������ʾ�������˶����ſ�Ŀ
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
					int rowSum = rs.getRow(); // ��ȡ��¼����
					rs.first();
					if (rowSum != 1) {
						flag = 2;
						System.out.print("��ȡrow��ֵ��" + sql +"  "+ rowSum);
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
	 *  ��ӿ�����Ϣ������ѧ���жϿ����Ƿ�ע�ᣬ���ѧ���Ѿ����ڣ���ʾ�����Ѿ�ע���������ֱ�ӵ�¼
	 */
	public String insert(StudentForm s) {
		String sql1 = "SELECT * FROM examineeinfo WHERE cardNo='" + s.getCardNo() + "'";
		System.out.println("����ѧ��Ϊ��"+s.getCardNo());
		ResultSet rs = conn.executeQuery(sql1); // ִ��SQL��ѯ���
		String sql = "";
		String falg = "miss"; // ���ڼ�¼������Ϣ�ı���
		String ID = "";
		try {
			if (rs.next()) { // ������ڼ�¼
				falg = "re"; // ��ʾ������Ϣ�Ѿ�ע��
			} else {
				/***************** �Զ�����׼��֤�� ***********************************************/
				String sql_max = "SELECT max(ID) FROM examineeinfo";
				ResultSet rs_max = conn.executeQuery(sql_max); // ��ѯ����׼��֤��
				java.util.Date date = new java.util.Date(); // ʵ����java.util.Date()��
				String newTime = new SimpleDateFormat("yyyyMMdd").format(date); // ��ʽ����ǰ����
				if (rs_max.next()) {
					String max_ID = rs_max.getString(1); // ��ȡ����׼��֤��
					int newId = Integer.parseInt(max_ID.substring(12, 16)) + 1;// ȡ�����׼��֤���е����ֱ��+1
					String no = chStr.formatNO(newId, 4); // �����ɵı�Ÿ�ʽ��Ϊ4λ
					ID = "GDOU" + newTime + no; // ���������׼��֤��
				} else { // ����һ������ע��ʱ
					ID = "GDOU" + newTime + "0001"; // ���ɵ�һ��׼��֤��
				}
                	/********************************************************************************/
              		sql = "INSERT INTO examineeinfo (ID,name,pwd,sex,joinTime,question,answer,profession,cardNo) values('" +
                                 ID+ "','" +s.getName() +"','"+s.getPwd()+"','"+s.getSex()+"',now(),'"+s.getQuestion()+
                                 "','"+s.getAnswer()+"','"+s.getProfession()+"','"+s.getCardNo()+"')";
				int ret = conn.executeUpdate(sql); // ���濼��ע����Ϣ
				if (ret == 0) {
					falg = "miss"; // ��ʾ����ע��ʧ��
				} else {
					falg = "��ϲ����ע��ɹ�!\\r���μ�����׼��֤�ţ�" + ID; // �������ɵ�׼��֤��
					System.out.println("����ע��ɹ�ʱ��׼��֤��Ϊ��" + ID);
				}
				conn.close(); // �ر����ݿ�����
			}
		} catch (Exception e) {
			falg = "miss";
			System.out.println("��ӿ�����Ϣʱ�Ĵ�����Ϣ��" + e.getMessage()); // ���������ʾ��Ϣ������̨
		}
		return falg;
	}

	/*
	 *  ��ѯ������Ϣ
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
	 *  �޸Ŀ�������
	 */
	public int update(StudentForm s) {
		String sql = "UPDATE examineeinfo SET pwd='" + s.getPwd() + "',sex='"
				+ s.getSex() + "',question='" + s.getQuestion() + "',answer='"
				+ s.getAnswer() + "',profession='" + s.getProfession()
				+ "' where ID='" + s.getID() + "'";
		int ret = conn.executeUpdate(sql);
		System.out.println("�޸Ŀ�������ʱ��SQL��" + sql);
		conn.close();
		return ret;
	}

	/*
	 *  �����һ����루��һ����������ѧ�Ų�����Ϣ
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
			System.out.println("�һ�׼��֤�����루��һ�������ֵĴ�����Ϣ��" + e.getMessage());
		}
		return s;
	}

	/*
	 *  �����һ����루�ڶ�������������ʾ�����
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
			System.out.println("�һ�׼��֤�����루�ڶ��������ֵĴ�����Ϣ��" + e.getMessage());
		}
		return s;
	}

	/*
	 *  ɾ��������Ϣ,ɾ��ʱ�жϸÿ����Ƿ��п��Գɼ����е�һ��ɾ��
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
			System.out.println("ɾ��ʱ��SQL��" + sql);
			flag = conn.executeUpdate(sql);
			String sql3 = "SELECT count(*) FROM examineescore where stuId in (" + id + ")";
			ResultSet rs1 = conn.executeQuery(sql3);
			try {
				rs1.next();
				if (!rs1.getString(1).equals("0")) {
					String sql4 = "DELETE FROM examineescore where stuId in (" + id + ")";
					flag = conn.executeUpdate(sql4);
					System.out.println("ɾ��ʱ��SQL��" + sql4);
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
