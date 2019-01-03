package com.oes.actionForm;

import java.util.Date;
import org.apache.struts.action.ActionForm;

/*
 * @ 试卷的详细信息 TestpaperInfo
 * TI_ID  编号
 * TI_Name  试卷名称
 * TI_CourseID  所属科目
 * TI_Addtime  试卷添加时间
 * 
 */

public class TaoTiForm extends ActionForm {
	
	private int ID;           //编号
	private String name;      //试卷名称
	private int lessonId;     //所属科目
	private Date joinTime;    //试卷添加时间
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