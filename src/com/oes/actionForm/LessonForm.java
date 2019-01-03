package com.oes.actionForm;

import java.util.Date;
import org.apache.struts.action.ActionForm;

/*
 * @ 科目的详细信息 CourseInfo
 *   CI_ID  编号
 *   CI_Name  科目名称
 *   CI_Addtime  科目添加时间
 */

public class LessonForm extends ActionForm {
	
	private int ID;             //编号
	private String name;        //科目名称
	private Date joinTime;	    //科目添加时间
	private String[] delIdArray=new String[0];
	private int xuhao;

	
	
	public int getXuhao() {
		return xuhao;
	}
	public void setXuhao(int xuhao) {
		this.xuhao = xuhao;
	}
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

}