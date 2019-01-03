package com.oes.action;

import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.oes.actionForm.LessonForm;
import com.oes.actionForm.MoreSelect;
import com.oes.actionForm.QuestionsForm;
import com.oes.actionForm.TaoTiForm;
import com.oes.core.ChStr;
import com.oes.dao.LessonDAO;
import com.oes.dao.StartExamDAO;
import com.oes.dao.TaoTiDAO;
import java.util.*;

public class StartExam extends Action {
	private StartExamDAO startExamDAO = null;
	ChStr chStr=new ChStr();

	public StartExam() {
		this.startExamDAO = new StartExamDAO();
	}
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		System.out.println("StartExam��ȡ�Ĳ�ѯ�ַ�����" + action);
		if ("startExam".equals(action)) {
			return startExam(mapping, form, request, response);
		}else if("Examanswer".equals(action)){
			return Examanswer(mapping,form,request,response);
		}else if("showExam".equals(action)){
			return showExam(mapping,form,request,response);
		}else if("submitTestPaper".equals(action)){
			return submitTestPaper(mapping,form,request,response);
		}else if("showStartTime".equals(action)){//��ʾ���Լ�ʱ
			return showStartTime(mapping,form,request,response);
		}else if("showRemainTime".equals(action)){//��ʾ����ʱ��
			return showRemainTime(mapping,form,request,response);
		}else{
			request.setAttribute("error", "����ʧ�ܣ�");
			return mapping.findForward("error");
		}
	}
	
	/*
	 * ��ʱ������ʱ��
	 */
	private ActionForward showStartTime(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//startTime�Ǵ��Ծ�ʼ����ʱ�䣬��ϵͳ��ǰʱ��b��ȥ���Ծ�ʱ��a���ó������Ǻ��룬�ٰѺ���ת����ʱ���֣���
		//����ʱ��̶�Ϊ��ʽ00:00:00,��ֵ��showStartTime		
		/*
		 * ͳ�ƴ�1970��1��1����ĺ����������ʾ���ڡ�Ҳ����˵�����磬1970��1��2�գ�����1��1�պ��86��400��000���롣
		 * ͬ���ģ�1969��12��31������1970��1��1��ǰ86��400��000���롣
		 * Java��Date��ʹ��long���ͼ�¼��Щ����ֵ.��Ϊlong���з����������������ڿ�����1970��1��1��֮ǰ��Ҳ��������֮��
		 * Long���ͱ�ʾ�������ֵ�����ֵ�������ɵı�ʾ290��000��000���ʱ�䣬���ʺϴ�����˵�ʱ��Ҫ�� 
		 */
		HttpSession session = request.getSession();
		String startTime=session.getAttribute("startTime").toString();
		long a=Long.parseLong(startTime);
		long b=new java.util.Date().getTime();
		int h=(int)Math.abs((b-a)/3600000);    //Math.abs()��ȡ����ֵ
		String hour=chStr.formatNO(h,2);       //formatNO(h,2)ʹʱ���ʽ�̶�Ϊ��λ
		int m=(int)(b-a)%3600000/60000;
		String minute=chStr.formatNO(m,2);
		int s=(int)((b-a)%3600000)%60000/1000;
		String second=chStr.formatNO(s,2);
		String time=hour+":"+minute+":"+second;
		request.setAttribute("showStartTime",time);
		return mapping.findForward("showStartTime");
	}
	
	/*
	 *  ����ʱ����ʾʣ��ʱ��
	 */
	private ActionForward showRemainTime(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//�÷�������ļ��㿪ʼʱ�����һ�������ÿ���ʱ��Ϊ10���ӣ������úõ�ʱ���ȥ����ʱ����ܵó�ʣ��ʱ��
		HttpSession session = request.getSession();
		String startTime=session.getAttribute("startTime").toString();
		long a=Long.parseLong(startTime);
		long b=new java.util.Date().getTime();
		long r=10*60000-(b-a-1000);     
		int h=(int)Math.abs(r/3600000);
		String hour=chStr.formatNO(h,2);
		int m=(int)(r)%3600000/60000;
		String minute=chStr.formatNO(m,2);
		int s=(int)((r)%3600000)%60000/1000;
		String second=chStr.formatNO(s,2);
		String time=hour+":"+minute+":"+second;
		request.setAttribute("showRemainTime",time);
		return mapping.findForward("showRemainTime");
	}

	/*
	 *  ��ȡ������Ŀ��Ϣ
	 */
	private ActionForward startExam(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("��ĿID��"+lessonForm.getID()+lessonForm.getName());
		System.out.println("------");
		HttpSession session = request.getSession();
		if(session.getAttribute("student")==null || session.getAttribute("student").equals("")){
			return mapping.findForward("dealNull");	//ת��ǰ̨��¼ҳ��
		}else{
			String student=session.getAttribute("student").toString();					//׼��֤��
			if(session.getAttribute("lessonID")==null || session.getAttribute("lessonID").equals("")){
				return mapping.findForward("dealNull");	//ת��ǰ̨��¼ҳ��
			}else{
				System.out.println("=============");
				int lessonID=Integer.parseInt(session.getAttribute("lessonID").toString());	//��ĿID
				System.out.println("lessonID123="+lessonID);
				//�����ȡ����
				int questions=startExamDAO.randomGetQuestion(lessonID);
				System.out.println("questions123="+questions);
				//�տ�ʼ����ʱ���濼�Խ��
				int ret=startExamDAO.startSaveResult(student,lessonID);
	            System.out.println("�տ�ʼ����ʱ���濼�Խ����"+ret);
				List singleQue=(List)startExamDAO.queryExam(questions,0);
				QuestionsForm q=(QuestionsForm)form;
				q.setSize(singleQue.size());
				request.setAttribute("singleQue",singleQue);			//��ȡ��ѡ��
				List moreQue=(List)startExamDAO.queryExam(questions,1);	//��ȡ��ѡ��
				q.setMoreSize(moreQue.size());	
				request.setAttribute("moreQue",moreQue);
				session.setAttribute("startTime",new java.util.Date().getTime());
				return mapping.findForward("testPaper");
			}
		}
	}
	
	/*
	 * �����鿴�Ծ��
	 */
	private ActionForward Examanswer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("------");
		HttpSession session = request.getSession();
		int lessonID =Integer.parseInt(request.getParameter("id")); // ��ĿID
		int total =Integer.parseInt(request.getParameter("total")); // �����Ծ�÷�
		System.out.println("lessonID="+lessonID);
		System.out.println("total="+total);
		session.setAttribute("lessonID", lessonID);
		session.setAttribute("total", total);
		int questions = startExamDAO.randomGetQuestion(lessonID);
		System.out.println("questions=" + questions);
		List singleQue = (List) startExamDAO.queryExam(questions, 0);
		QuestionsForm q = (QuestionsForm) form;
		q.setSize(singleQue.size());
		request.setAttribute("singleQue", singleQue); // ��ȡ��ѡ��
		List moreQue = (List) startExamDAO.queryExam(questions, 1); // ��ȡ��ѡ��
		q.setMoreSize(moreQue.size());
		request.setAttribute("moreQue", moreQue);
		session.setAttribute("startTime", new java.util.Date().getTime());
		return mapping.findForward("testPaper1");
	}
	
	/*
	 * ����Ա�鿴�����Ծ�
	 */
	private ActionForward showExam(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("------");
		HttpSession session = request.getSession();
		int lessonID =Integer.parseInt(request.getParameter("id")); // ��ĿID		
		System.out.println("lessonID="+lessonID);		
		session.setAttribute("lessonID", lessonID);		
		int questions = startExamDAO.randomGetQuestion(lessonID);
		System.out.println("questions=" + questions);
		List singleQue = (List) startExamDAO.queryExam(questions, 0);
		QuestionsForm q = (QuestionsForm) form;
		if(singleQue.size()==0){
			request.setAttribute("error", "��ӿ�Ŀ��Ϣ��������Ծ���Ϣ����Ŀ��Ϣ���ܲ鿴�Ծ�");
			return mapping.findForward("errorback");
			
		}else{
			q.setSize(singleQue.size());
			System.out.println("��ѡ�����:"+singleQue.size());
			request.setAttribute("singleQue", singleQue); // ��ȡ��ѡ��
			List moreQue = (List) startExamDAO.queryExam(questions, 1); // ��ȡ��ѡ��
			q.setMoreSize(moreQue.size());
			request.setAttribute("moreQue", moreQue);
			session.setAttribute("startTime", new java.util.Date().getTime());
			return mapping.findForward("testPaper2");
		}		
	}

	/*
	 * �ύ�Ծ�
	 */
	private ActionForward submitTestPaper(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		QuestionsForm q=(QuestionsForm)form;
		String rightAnswer="";
		float singleMark=0;
		float moreMark=0;
		/****************************ͳ�Ƶ�ѡ��ĵ÷�**************************************/
		String[] single=q.getAnswerArrS();
		int[] singleId=q.getIdArrS();
		System.out.println(q.getID());
		System.out.println("���ݵĳ��ȣ�"+single.length);
		float markS=40/(single.length);
		for(int i=0;i<single.length;i++){
			//����getRightAnswer()������ȡ��ȷ��
			rightAnswer=startExamDAO.getRightAnswer(singleId[i]);
			System.out.println("��ѡ���飺"+i+"********ID��"+singleId[i]+"********"+single[i]+"****��ȷ��"+rightAnswer);
			if(rightAnswer.equals(single[i])){
				singleMark=singleMark+markS;	//�ۼӵ�ѡ��ķ���
			}			
		}
		System.out.println("��ѡ��÷֣�"+singleMark);
		/*********************************************************************************/
		/****************************ͳ�ƶ�ѡ��ĵ÷�**************************************/
		MoreSelect[] more=q.getMoreSelect();
		System.out.println("��ѡ����ĳ��ȣ�"+more.length);
		float markM=60/(more.length);
		String str="";
		for(int i=0;i<more.length;i++){
			String[] ans=more[i].getAnswerArr();
			int[] moreId=q.getIdArrM();
			rightAnswer=startExamDAO.getRightAnswer(moreId[i]);
			System.out.println("��ѡ���飺"+i+"********ID��"+moreId[i]+"********"+more[i]+"****��ȷ��"+rightAnswer);
			for(int j=0;j<ans.length;j++){
				if(ans[j]!=null) str=str+ans[j]+",";
    		}
    		if(str.length()>1){
    			str=str.substring(0,str.length()-1);
    		}
    		
			System.out.println("��ȡ�Ķ�ѡ��𰸣�"+str);
			if(rightAnswer.equals(str)){
				moreMark=moreMark+markM;	//�ۼӶ�ѡ��ķ���
			}	
			str="";
		}
		System.out.println("��ѡ��÷֣�"+moreMark);
		/*********************************************************************************/
		HttpSession session = request.getSession();
		String student=session.getAttribute("student").toString();
		int lessonID=Integer.parseInt(session.getAttribute("lessonID").toString());	//�γ�ID
		int ret=startExamDAO.saveResult(student,lessonID,(int)Math.round(singleMark),(int)Math.round(moreMark));
		if(ret>0){
			request.setAttribute("submitTestPaperok", "�Ծ����ύ�������ο��Եĳɼ�Ϊ��"+(Math.round(singleMark)+Math.round(moreMark))+"�֣�");
			return mapping.findForward("submitTestPaperok");
		}else{
			return mapping.findForward("dealNull");
		}
	}

}
