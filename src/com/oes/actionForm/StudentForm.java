package com.oes.actionForm;

import java.util.Date;
import org.apache.struts.action.ActionForm;

/*
 * @ ��������ϸ��Ϣ ExamineeInfo
 * EI_ID  ����׼��֤��
 * EI_Cno  ����ѧ��
 * EI_Name  ��������
 * EI_Sex  �����Ա�
 * EI_Profession  ����רҵ
 * EI_Password  ����
 * EI_Question  ��ʾ����
 * EI_Answer  �����
 * EI_Joiningday  ע��ʱ��
 * 
 */

public class StudentForm extends ActionForm {
	
	private String ID;           //����׼��֤��
	private String cardNo;       //����ѧ��
	private String name;         //��������
	private String sex;          //�����Ա�
	private String profession;   //����רҵ
	private String pwd;          //����
	private String question;     //��ʾ����
	private String answer;       //�����
	private Date joinTime;		 //ע��ʱ��
	private String oldpwd;       //ԭ����
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