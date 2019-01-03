package com.oes.actionForm;

import java.util.Date;
import org.apache.struts.action.ActionForm;

/*
 * @ ������Ŀ����ϸ��Ϣ QuestionsInfo
 *  QI_ID  ���
 *  QI_CourseID  ������Ŀ
 *  QI_TestID  �����Ծ�
 *  QI_Name ������Ŀ
 *  QI_Type  ��Ŀ����
 *  QI_SelectA  ѡ��A
 *  QI_SelectB  ѡ��B
 *  QI_SelectC  ѡ��C
 *  QI_SelectD  ѡ��D
 *  QI_Rightanswer  ��ȷ��
 *  QI_Addtime  ��Ŀ���ʱ��
 *  QI_Note  ��ע
 *  
 */

public class QuestionsForm extends ActionForm {
	
	private int ID;               //���
	private int lessonId;         //������Ŀ
	private int taoTiId;          //�����Ծ�
	private String subject;       //��Ŀ����
	private String type;          //��Ŀ����
	private String optionA;       //Aѡ��
	private String optionB;       //Bѡ��
	private String optionC;       //Cѡ��
	private String optionD;       //Dѡ��
	private String answer;        //��ȷ��
	private Date joinTime;        //��Ŀ���ʱ��
	private String note;          //��ע
	private int[] idArrS;	     //��¼��ѡ�������ID������
	private int[] idArrM;	    //��¼��ѡ�������ID������
	private String[] delIdArray=new String[0];	
	private String[] answerArr=new String[0];
	private String[] answerArrS;
	private MoreSelect[] moreSelect;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public int getTaoTiId() {
		return taoTiId;
	}

	public void setTaoTiId(int taoTiId) {
		this.taoTiId = taoTiId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int[] getIdArrS() {
		return idArrS;
	}

	public void setIdArrS(int[] idArrS) {
		this.idArrS = idArrS;
	}

	public int[] getIdArrM() {
		return idArrM;
	}

	public void setIdArrM(int[] idArrM) {
		this.idArrM = idArrM;
	}

	public String[] getDelIdArray() {
		return delIdArray;
	}

	public void setDelIdArray(String[] delIdArray) {
		this.delIdArray = delIdArray;
	}

	public String[] getAnswerArr() {
		return answerArr;
	}

	public void setAnswerArr(String[] answerArr) {
		this.answerArr = answerArr;
	}

	public String[] getAnswerArrS() {
		return answerArrS;
	}

	public void setAnswerArrS(String[] answerArrS) {
		this.answerArrS = answerArrS;
	}

	public void setSize(int size){
		answerArrS=new String[size];
		idArrS=new int[size];
		System.out.println("��ѡ��������С��"+answerArrS.length);
	}

	public MoreSelect[] getMoreSelect() {
		return moreSelect;
	}
	public void setMoreSelect(MoreSelect[] moreSelect) {
		this.moreSelect = moreSelect;
	}
	public void setMoreSize(int size){
		idArrM=new int[size];
		moreSelect=new MoreSelect[size];
		for(int i=0;i<size;i++)
			moreSelect[i]=new MoreSelect();
		System.out.println("��ѡ�⣺"+moreSelect.length);
	}	
}