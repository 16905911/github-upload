package com.oes.actionForm;

import java.util.Date;
import org.apache.struts.action.ActionForm;

/*
 * @ 考试题目的详细信息 QuestionsInfo
 *  QI_ID  编号
 *  QI_CourseID  所属科目
 *  QI_TestID  所属试卷
 *  QI_Name 考试题目
 *  QI_Type  题目类型
 *  QI_SelectA  选项A
 *  QI_SelectB  选项B
 *  QI_SelectC  选项C
 *  QI_SelectD  选项D
 *  QI_Rightanswer  正确答案
 *  QI_Addtime  题目添加时间
 *  QI_Note  备注
 *  
 */

public class QuestionsForm extends ActionForm {
	
	private int ID;               //编号
	private int lessonId;         //所属科目
	private int taoTiId;          //所属试卷
	private String subject;       //题目名称
	private String type;          //题目类型
	private String optionA;       //A选项
	private String optionB;       //B选项
	private String optionC;       //C选项
	private String optionD;       //D选项
	private String answer;        //正确答案
	private Date joinTime;        //题目添加时间
	private String note;          //备注
	private int[] idArrS;	     //记录单选题的试题ID的属性
	private int[] idArrM;	    //记录多选题的试题ID的属性
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
		System.out.println("单选题的数组大小："+answerArrS.length);
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
		System.out.println("多选题："+moreSelect.length);
	}	
}