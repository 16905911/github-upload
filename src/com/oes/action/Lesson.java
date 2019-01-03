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
		System.out.println("Lesson获取的查询字符串：" + action);
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
		request.setAttribute("error", "操作失败！");
		return mapping.findForward("error");
	}

	
	/*
	 *  修改科目时的查询
	 */
	private ActionForward lessonModifyQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LessonForm lessonForm=(LessonForm)((lessonDAO.query(Integer.parseInt(request.getParameter("id")))).get(0));
		request.setAttribute("lessonModifyQuery", lessonForm);
		return mapping.findForward("lessonModifyQuery");
	}
	
	/*
	 * 修改科目信息
	 */
	private ActionForward lessonModify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LessonForm lessonForm = (LessonForm) form;
		int ret = lessonDAO.update(lessonForm);
		System.out.println("ret="+ret);
		if (ret == 0) {
			request.setAttribute("error", "修改科目失败！");
			return mapping.findForward("error");
		} else {
			return mapping.findForward("lessonModify");
		}
	}	
	
	/*
	 *  查询科目信息
	 */
	private ActionForward lessonQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("lessonQuery", lessonDAO.query(0));
		return mapping.findForward("lessonQuery");
	}

	/*
	 *  添加科目
	 */
	private ActionForward lessonAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LessonForm lessonForm = (LessonForm) form;
		int ret = lessonDAO.insert(lessonForm);
		System.out.println("lessonAdd返回值ret：" + ret);
		if (ret == 1) {
			return mapping.findForward("lessonAdd");
		} else if (ret == 2) {
			request.setAttribute("error", "该科目已经添加！");
			return mapping.findForward("error");
		} else {
			request.setAttribute("error", "添加课科目失败！");
			return mapping.findForward("error");
		}
	}

	/*
	 *  添加科目时查询
	 */
	private ActionForward lessonAddQuery(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("lessonList", lessonDAO.query(0)); // 全部科目列表
		return mapping.findForward("lessonAddQuery");
	}

	/*
	 *  删除科目
	 */
	private ActionForward lessonDel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LessonForm lessonForm = (LessonForm) form;
		int ret = lessonDAO.delete(lessonForm);
		if (ret == 0) {
			request.setAttribute("error", "删除科目失败！");
			return mapping.findForward("error");
		} else {
			return mapping.findForward("lessonDel");
		}
	}

	/*
	 *  在线考试时选择科目
	 */
	private ActionForward selectLesson(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String stu = session.getAttribute("student").toString(); // 获取准考证号
		List list = lessonDAO.query(stu); // 查询包括考试题目的科目列表，但不包括已经考过的科目
		if (list.size() < 1) {
			return mapping.findForward("noenLesson");
		} else {
			request.setAttribute("lessonList", list);
			return mapping.findForward("selectLesson");
		}
	}

	/*
	 *  准备考试
	 */
	private ActionForward ready(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LessonForm lessonForm = (LessonForm) form;
		System.out.println("科目ID：" + lessonForm.getID() + "科目名称：" + lessonForm.getName());
		HttpSession session = request.getSession();
		session.setAttribute("lessonID", String.valueOf(lessonForm.getID())); // 查询选择的科目ID
		return mapping.findForward("ready");
	}
}