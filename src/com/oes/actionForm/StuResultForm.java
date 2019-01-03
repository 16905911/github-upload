package com.oes.actionForm;

import java.util.Date;
import org.apache.struts.action.ActionForm;

/*
 * @ ����ɼ�����ϸ��Ϣ ExamineeScore
 * ES_ID  ���
 * ES_EID  ׼��֤��
 * ES_Course  ���Կ�Ŀ
 * ES_Radioscore  ��ѡ�����
 * ES_Checkedscore  ��ѡ�����
 * ES_Totalscore  �ܷ�
 * ES_Answertime  ����ʱ��
 * 
 */

public class StuResultForm extends ActionForm {
	
	private String name;
	private String profession;
	private String sex;
	private String CNo;
	private int lessonID;
	
	private int ID;                  //���
	private String stuId;            //����׼��֤��
	private String whichLesson;      //���Կ�Ŀ
	private int test_room;			//���Կ���
	private int resSingle;           //��ѡ��÷�
	private int resMore;             //��ѡ��÷�	
	private int resTotal;            //�ܷ�
	private Date joinTime;           //����ʱ��
	
	public int getLessonID() {
		return lessonID;
	}
	public void setLessonID(int lessonID) {
		this.lessonID = lessonID;
	}
	public String getCNo() {
		return CNo;
	}
	public void setCNo(String cNo) {
		CNo = cNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getWhichLesson() {
		return whichLesson;
	}
	public void setWhichLesson(String whichLesson) {
		this.whichLesson = whichLesson;
	}

	public int getTest_room() {
		return test_room;
	}
	public void setTest_room(int test_room) {
		this.test_room = test_room;
	}
	public int getResSingle() {
		return resSingle;
	}
	public void setResSingle(int resSingle) {
		this.resSingle = resSingle;
	}
	public int getResMore() {
		return resMore;
	}
	public void setResMore(int resMore) {
		this.resMore = resMore;
	}
	public int getResTotal() {
		return resTotal;
	}
	public void setResTotal(int resTotal) {
		this.resTotal = resTotal;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	
	
}