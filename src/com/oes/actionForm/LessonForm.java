package com.oes.actionForm;

import java.util.Date;
import org.apache.struts.action.ActionForm;

/*
 * @ ��Ŀ����ϸ��Ϣ CourseInfo
 *   CI_ID  ���
 *   CI_Name  ��Ŀ����
 *   CI_Addtime  ��Ŀ���ʱ��
 */

public class LessonForm extends ActionForm {
	
	private int ID;             //���
	private String name;        //��Ŀ����
	private Date joinTime;	    //��Ŀ���ʱ��
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