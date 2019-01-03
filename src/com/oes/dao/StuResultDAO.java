package com.oes.dao;

import com.oes.actionForm.QueryResultIfForm;
import com.oes.actionForm.StuResultForm;
import com.oes.core.ConnDB;

import java.sql.*;
import java.util.*;

public class StuResultDAO {
	private ConnDB conn=new ConnDB();
	
    /*
     * ����ɼ���ѯ������ȫ����ѯ������������ѯ�����������и�ݿ���׼��֤��ѯ����ݿ��Կ�Ŀ��ѯ
     * �˴��������ű?һ�ſ�Ŀ�?һ�ſ�����Ϣ�?һ�ſ���ɼ��?��ѯ����ɼ��ģ�˳���ѯ�����������Ϣ�����п�ĿID��Ϊ�˿������ѯ���õ�
     */
    public List query(String stuId) {
    	List stuResultList = new ArrayList();
        StuResultForm stuResultForm1 = null;
        String sql="";
        if(stuId.equals("")){
            sql = "SELECT examineescore.*,examineeinfo.name,profession,sex,cardNo,courseinfo.ID " +
            		"FROM examineescore,examineeinfo,courseinfo " +
            		"WHERE examineeinfo.ID=examineescore.stuId AND courseinfo.Name=examineescore.whichLesson " +
            		"ORDER BY examineescore.joinTime DESC";
        }else{
        	sql = "SELECT examineescore.*,examineeinfo.name,profession,sex,cardNo,courseinfo.ID " +
        			"FROM examineescore,examineeinfo,courseinfo " +
        			"WHERE examineeinfo.ID=examineescore.stuId AND courseinfo.Name=examineescore.whichLesson " +
        			"AND examineescore.stuId='" +stuId+ "'";
        }
        ResultSet rs = conn.executeQuery(sql);
        try {
            while (rs.next()) {
                stuResultForm1 = new StuResultForm();
                stuResultForm1.setID(rs.getInt(1));
                stuResultForm1.setStuId(rs.getString(2));
                stuResultForm1.setWhichLesson(rs.getString(3));
                stuResultForm1.setTest_room(rs.getInt(4));
                stuResultForm1.setResMore(rs.getInt(5));
                stuResultForm1.setResTotal(rs.getInt(6));
                stuResultForm1.setJoinTime(java.text.DateFormat.getDateTimeInstance().parse(rs.getString(7)));
                stuResultForm1.setName(rs.getString(8));
                stuResultForm1.setProfession(rs.getString(9));
                stuResultForm1.setSex(rs.getString(10));      
                stuResultForm1.setCNo(rs.getString(11)); 
                stuResultForm1.setLessonID(rs.getInt(12));
                stuResultList.add(stuResultForm1);
            }
        } catch (Exception ex) {
        	System.out.println("��ѯѧ��ɼ�(ȫ���Ͱ�׼��֤��ȷ��ѯ)ʱ����Ĵ���"+ex.getMessage());
        }
        return stuResultList;
    }
    
    /*
     * ��ȡһ���ж���ҳ
     */
    public int getTotalPages(int pageSize){
    	int total = 0;
    	int totalPages = 0;
    	try {
			String sql = "SELECT COUNT(*) FROM examineescore,examineeinfo " +
					"WHERE examineeinfo.ID=examineescore.stuId ORDER BY examineescore.joinTime DESC";
			ResultSet rs = conn.executeQuery(sql);
			while(rs.next()){
				total =rs.getInt(1);
			}
			if(total%pageSize == 0){
				totalPages = total/pageSize;
			}else{
				totalPages = total/pageSize +1;
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return totalPages;
    }
       
     /*
      * ��ȡ��ǰҳ�ļ�¼��  
      */
    public List<StuResultForm> queryByPage(int page, int pageSize){
    	List<StuResultForm> stuResultList = new ArrayList<StuResultForm>(); 
        StuResultForm stuResultForm1 = null;
    	int begin = (page-1)*pageSize;
    	int end = pageSize;
    	try {
			String sql = 
	  "SELECT examineescore.*,NAME,profession,sex  " +
	  "FROM examineescore,examineeinfo WHERE examineeinfo.ID=examineescore.stuId " +
	  "ORDER BY examineescore.joinTime DESC limit "+ begin +","+ pageSize+ "";
			System.out.println(sql);
			ResultSet rs = conn.executeQuery(sql);
			while(rs.next()){
				  stuResultForm1 = new StuResultForm();
	                stuResultForm1.setID(rs.getInt(1));
	                stuResultForm1.setStuId(rs.getString(2));
	                stuResultForm1.setWhichLesson(rs.getString(3));
	                stuResultForm1.setTest_room(rs.getInt(4));
	                stuResultForm1.setResMore(rs.getInt(5));
	                stuResultForm1.setResTotal(rs.getInt(6));
	                stuResultForm1.setJoinTime(java.text.DateFormat.getDateTimeInstance().parse(rs.getString(7)));
	                stuResultForm1.setName(rs.getString(8));
	                stuResultForm1.setProfession(rs.getString(9));
	                stuResultForm1.setSex(rs.getString(10)); 
	                stuResultList.add(stuResultForm1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sql����쳣��");
		}finally{
			conn.close();
		}   	
    	return stuResultList;
    }
        
    /*
     * ���������ѯ����ĳɼ���Ϣ
     */
    public List query(QueryResultIfForm q){
    	List stuResultList = new ArrayList();
        StuResultForm stuResultForm1 = null;
        String sql="SELECT examineescore.*,NAME,profession,sex FROM examineescore,examineeinfo " +
        		"WHERE examineeinfo.ID=examineescore.stuId AND "+q.getQueryIf()+" like '%"+q.getKey()+"%' " +
        				"ORDER BY examineescore.joinTime DESC";
        //��ѯq.getQueryIf()��Ӧ��ѯѡ������ݣ���ѯq.getQueryIf()��Ӧ��ѯ�ı�������
        System.out.println("���������ѯ����ĳɼ���ϢSQL��"+sql);
        ResultSet rs = conn.executeQuery(sql);
        try {
            while (rs.next()) {
                stuResultForm1 = new StuResultForm();
                stuResultForm1.setID(rs.getInt(1));
                stuResultForm1.setStuId(rs.getString(2));
                stuResultForm1.setWhichLesson(rs.getString(3));
                stuResultForm1.setResSingle(rs.getInt(4));
                stuResultForm1.setResMore(rs.getInt(5));
                stuResultForm1.setResTotal(rs.getInt(6));
                stuResultForm1.setJoinTime(java.text.DateFormat.getDateTimeInstance().parse(rs.getString(7)));
                stuResultForm1.setName(rs.getString(8));
                stuResultForm1.setProfession(rs.getString(9));
                stuResultForm1.setSex(rs.getString(10)); 
                stuResultList.add(stuResultForm1);
            }
        } catch (Exception ex) {
        	System.out.println("��������ѯѧ��ɼ�ʱ����Ĵ���"+ex.getMessage());
        }
        return stuResultList;
    }

}
