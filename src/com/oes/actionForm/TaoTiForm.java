package com.oes.actionForm;

import java.util.Date;
import org.apache.struts.action.ActionForm;

/*
 * @ �Ծ����ϸ��Ϣ TestpaperInfo
 * TI_ID  ���
 * TI_Name  �Ծ�����
 * TI_CourseID  ������Ŀ
 * TI_Addtime  �Ծ����ʱ��
 * 
 */

public class TaoTiForm extends ActionForm {
	
	private int ID;           //���
	private String name;      //�Ծ�����
	private int lessonId;     //������Ŀ
	private Date joinTime;    //�Ծ����ʱ��
	private String[] delIdArray=new String[0];
	private String[] nameArray=new String[0];
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public String[] getDelIdArray() {
		return delIdArray;
	}
	public void setDelIdArray(String[] delIdArray) {
		this.delIdArray = delIdArray;
	}
	public String[] getNameArray() {
		return nameArray;
	}
	public void setNameArray(String[] nameArray) {
		this.nameArray = nameArray;
	}
	
}