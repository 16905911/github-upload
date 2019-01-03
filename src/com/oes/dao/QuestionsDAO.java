package com.oes.dao;

import com.oes.actionForm.QuestionsForm;
import com.oes.core.ConnDB;
import java.sql.*;
import java.util.*;

public class QuestionsDAO {
	private ConnDB conn=new ConnDB();
	
    /*
     * 添加考试题目
     */
    public int insert(QuestionsForm q) {
        String sql1="SELECT * FROM questionsinfo WHERE subject='"+q.getSubject()+"' AND taoTiId="+q.getTaoTiId()+"";
        ResultSet rs = conn.executeQuery(sql1);
        System.out.println("添加时的查询" + sql1);
        String sql = "";
        String answer="";
        int falg = 0;
            try {
                if (rs.next()) {
                    falg=2;
                } else {
                	if(q.getType().equals("多选题")){
	            		String[] mOption=(String [])q.getAnswerArr();
	                	if (mOption.length>0){
	                		String str="";
	                		for(int i=0;i<mOption.length;i++){
	                			str=str+mOption[i]+",";
	                		}
	                		str=str.substring(0,str.length()-1);
	                		answer=str;
	                	}
                	}else{
                		answer=q.getAnswer();
                	}
                    sql = "INSERT INTO questionsinfo (id,subject,type,joinTime,lessonId,taoTiId,optionA,optionB,optionC,optionD,answer,note) " +
                    		"values(null,'" + q.getSubject() + "','"+q.getType()+"',now(),"+q.getLessonId()+","+q.getTaoTiId()+"," +
                    				"'"+q.getOptionA()+"','"+q.getOptionB()+"','"+q.getOptionC()+"','"+q.getOptionD()+"','"+answer+"','"+q.getNote()+"')";
                    falg = conn.executeUpdate(sql);
                    System.out.println("添加考试题目时的SQL：" + sql);
                    conn.close();
                }
            } catch (Exception ex) {
                falg=0;
            }finally{
            	conn.close();
            }
        return falg;
    }
    
    /*
     * 查询考试题目方法
     */
    public List query(int id) {
    	List questionsList = new ArrayList();
        QuestionsForm questionsForm1 = null;
        String sql="";
        if(id==0){
            sql = "SELECT * FROM questionsinfo ORDER BY lessonId DESC,taoTiId DESC,type";
        }else{
        	sql = "SELECT * FROM questionsinfo WHERE id=" +id+ "";
        }
        ResultSet rs = conn.executeQuery(sql);
        String type="";
        String answer="";
        try {
            while (rs.next()) {
                questionsForm1 = new QuestionsForm();
                questionsForm1.setID(rs.getInt(1));
                questionsForm1.setSubject(rs.getString(2));
                type=rs.getString(3);
                questionsForm1.setType(type);
                questionsForm1.setJoinTime(java.text.DateFormat.getDateTimeInstance().parse(rs.getString(4)));               
                questionsForm1.setLessonId(rs.getInt(5));
                questionsForm1.setTaoTiId(rs.getInt(6));
                questionsForm1.setOptionA(rs.getString(7));
                questionsForm1.setOptionB(rs.getString(8));
                questionsForm1.setOptionC(rs.getString(9));
                questionsForm1.setOptionD(rs.getString(10));
                if(type.equals("多选题")){
                	String[] ans=rs.getString(11).split(",");   //split是返回一个数组，元素之间用逗号隔开
                	questionsForm1.setAnswerArr(ans);
                }else{
                	questionsForm1.setAnswer(rs.getString(11));
                }
                questionsForm1.setNote(rs.getString(12));
                questionsList.add(questionsForm1);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }finally{
        	conn.close();
        }
        return questionsList;
    }

    /*
     * 修改考试题目
     */
    public int update(QuestionsForm q){
    	String answer="";
       	if(q.getType().equals("多选题")){
    		String[] mOption=(String [])q.getAnswerArr();
        	if (mOption.length>0){
        		String str="";
        		for(int i=0;i<mOption.length;i++){
        			str=str+mOption[i]+",";
        		}
        		str=str.substring(0,str.length()-1);
        		answer=str;
        	}
    	}else{
    		answer=q.getAnswer();
    	}
        String sql="UPDATE questionsinfo SET subject=" +
        		"'"+q.getSubject()+"',type='"+q.getType()+"',optionA='"+q.getOptionA()+"'," +
        				"optionB='"+q.getOptionB()+"',optionC='"+q.getOptionC()+"',optionD='"+q.getOptionD()+"'," +
        						"answer='"+answer+"',note='"+q.getNote()+"' where id="+q.getID()+"";
        int ret=conn.executeUpdate(sql);
        System.out.println("修改考试题目时的SQL："+sql);
        conn.close();
        return ret;
    }
    
    /*
     * 根据所属试卷查询试卷名称(通过jsp:useBean调用)
     */
    public String getTaoTi(int id){
    	String taoTiName="";
    	if(id>0){
    		String sql="SELECT * FROM testpaperinfo WHERE id="+id+"";
    		ResultSet rs=conn.executeQuery(sql);
            try {
                if(rs.next()) {
                	taoTiName=rs.getString(2);
                }
            }  catch (Exception e) {
            	e.printStackTrace();
            }finally{
            	conn.close();
            }  		
    	}
    	return taoTiName;
    }
    
      /*
       *  删除考试题目
       */
        public int delete(QuestionsForm questionsForm) {
        	int flag=0;
        	String[] delId=questionsForm.getDelIdArray();
        	if (delId.length>0){
        		String id="";
        		for(int i=0;i<delId.length;i++){
        			id=id+delId[i]+",";
        		}
        		id=id.substring(0,id.length()-1);
                String sql = "DELETE FROM questionsinfo where id in (" + id +")";
                flag = conn.executeUpdate(sql);
                conn.close();
        	}else{
        		flag=0;
        	}
            return flag;
        }
}
