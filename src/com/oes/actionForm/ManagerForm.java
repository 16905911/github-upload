package com.oes.actionForm;

import org.apache.struts.action.ActionForm;

/*
 * @ ����Ա����ϸ��Ϣ Admininfo 
 *  AI_ID  ���
 *  AI_Name  ����Ա����
 *  AI_Password  ����Ա���� 
 */

public class ManagerForm extends ActionForm {
	
	private int ID;			//���
	private String name;	//����Ա����
	private String pwd;		//����Ա����	
	private String oldpwd;	//ԭ����
	
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

}