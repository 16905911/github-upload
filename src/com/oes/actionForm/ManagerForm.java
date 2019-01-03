package com.oes.actionForm;

import org.apache.struts.action.ActionForm;

/*
 * @ 管理员的详细信息 Admininfo 
 *  AI_ID  编号
 *  AI_Name  管理员名称
 *  AI_Password  管理员密码 
 */

public class ManagerForm extends ActionForm {
	
	private int ID;			//编号
	private String name;	//管理员名称
	private String pwd;		//管理员密码	
	private String oldpwd;	//原密码
	
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