package com.oes.actionForm;

import java.util.Date;
import org.apache.struts.action.ActionForm;

/*
 * @ 考生的详细信息 ExamineeInfo
 * EI_ID  考生准考证号
 * EI_Cno  考生学号
 * EI_Name  考生姓名
 * EI_Sex  考生性别
 * EI_Profession  考生专业
 * EI_Password  密码
 * EI_Question  提示问题
 * EI_Answer  问题答案
 * EI_Joiningday  注册时间
 * 
 */

public class StudentForm extends ActionForm {
	
	private String ID;           //考生准考证号
	private String cardNo;       //考生学号
	private String name;         //考生姓名
	private String sex;          //考生性别
	private String profession;   //考生专业
	private String pwd;          //密码
	private String question;     //提示问题
	private String answer;       //问题答案
	private Date joinTime;		 //注册时间
	private String oldpwd;       //原密码
	private String[] delIdArray = new String[0];
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String[] getDelIdArray() {
		return delIdArray;
	}
	public void setDelIdArray(String[] delIdArray) {
		this.delIdArray = delIdArray;
	}
	
}