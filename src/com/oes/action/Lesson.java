package com.oes.action;

import java.util.List;
import javax.servlet.http.*;

import org.apache.struts.action.*;

import com.oes.actionForm.LessonForm;
import com.oes.actionForm.QuestionsForm;
import com.oes.dao.LessonDAO;

public class Lesson extends Action {
	
	private LessonDAO lessonDAO = null;

	public Lesson() {
		this.lessonDAO = new LessonDAO();
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		System.out.println("Lesson��ȡ�Ĳ�ѯ�ַ�����" + action);
		if (action == null || "".equals(action)) {
			return mapping.findForward("error");
		} else if ("lessonQuery".equals(action)) {
			return lessonQuery(mapping, form, request, response);
		} else if ("lessonAddQuery".equals(action)) {
			return lessonAddQuery(mapping, form, request, response);
		} else if ("lessonAdd".equals(action)) {
			return lessonAdd(mapping, form, request, response);
		} else if ("lessonDel".equals(action)) {
			return lessonDel(mapping, form, request, response);
		} else if ("selectLesson".equals(action)) {
			return selectLesson(mapping, form, request, response);
		} else if ("ready".equals(action)) {
			return ready(mapping, form, request, response);
		}else if("lessonModifyQuery".equals(action)){
			return lessonModifyQuery(mapping,form,request,response);
		}else if("lessonModify".equals(action)){
			return lessonModify(mapping,form,request,response);
		}
		request.setAttribute("error", "����ʧ�ܣ�");
		return mapping.findForward("error");
	}

	
	/*
	 *  �޸Ŀ�Ŀʱ�Ĳ�ѯ
	 */
	private ActionForward lessonModifyQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LessonForm lessonForm=(LessonForm)((lessonDAO.query(Integer.parseInt(request.getParameter("id")))).get(0));
		request.setAttribute("lessonModifyQuery", lessonForm);
		return mapping.findForward("lessonModifyQuery");
	}
	
	/*
	 * �޸Ŀ�Ŀ��Ϣ
	 */
	private ActionForward lessonModify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LessonForm lessonForm = (LessonForm) form;
		int ret = lessonDAO.update(lessonForm);
		System.out.println("ret="+ret);
		if (ret == 0) {
			request.setAttribute("error", "�޸Ŀ�Ŀʧ�ܣ�");
			return mapping.findForward("error");
		} else {
			return mapping.findForward("lessonModify");
		}
	}	
	
	/*
	 *  ��ѯ��Ŀ��Ϣ
	 */
	private ActionForward lessonQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("lessonQuery", lessonDAO.query(0));
		return mapping.findForward("lessonQuery");
	}

	/*
	 *  ��ӿ�Ŀ
	 */
	private ActionForward lessonAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LessonForm lessonForm = (LessonForm) form;
		int ret = lessonDAO.insert(lessonForm);
		System.out.println("lessonAdd����ֵret��" + ret);
		if (ret == 1) {
			return mapping.findForward("lessonAdd");
		} else if (ret == 2) {
			request.setAttribute("error", "�ÿ�Ŀ�Ѿ���ӣ�");
			return mapping.findForward("error");
		} else {
			request.setAttribute("error", "��ӿο�Ŀʧ�ܣ�");
			return mapping.findForward("error");
		}
	}

	/*
	 *  ��ӿ�Ŀʱ��ѯ
	 */
	private ActionForward lessonAddQuery(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("lessonList", lessonDAO.query(0)); // ȫ����Ŀ�б�
		return mapping.findForward("lessonAddQuery");
	}

	/*
	 *  ɾ����Ŀ
	 */
	private ActionForward lessonDel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LessonForm lessonForm = (LessonForm) form;
		int ret = lessonDAO.delete(lessonForm);
		if (ret == 0) {
			request.setAttribute("error", "ɾ����Ŀʧ�ܣ�");
			return mapping.findForward("error");
		} else {
			return mapping.findForward("lessonDel");
		}
	}

	/*
	 *  ���߿���ʱѡ���Ŀ
	 */
	private ActionForward selectLesson(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String stu = session.getAttribute("student").toString(); // ��ȡ׼��֤��
		List list = lessonDAO.query(stu); // ��ѯ����������Ŀ�Ŀ�Ŀ�б����������Ѿ������Ŀ�Ŀ
		if (list.size() < 1) {
			return mapping.findForward("noenLesson");
		} else {
			request.setAttribute("lessonList", list);
			return mapping.findForward("selectLesson");
		}
	}

	/*
	 *  ׼������
	 */
	private ActionForward ready(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LessonForm lessonForm = (LessonForm) form;
		System.out.println("��ĿID��" + lessonForm.getID() + "��Ŀ���ƣ�" + lessonForm.getName());
		HttpSession session = request.getSession();
		session.setAttribute("lessonID", String.valueOf(lessonForm.getID())); // ��ѯѡ��Ŀ�ĿID
		return mapping.findForward("ready");
	}
}