package com.oes.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.oes.actionForm.QueryResultIfForm;
import com.oes.actionForm.StuResultForm;
import com.oes.dao.StuResultDAO;

public class StuResult extends Action {
	private StuResultDAO stuResultDAO = null;
	private int pageSize = 10; //一页显示的记录数 
	private int page ; //默认显示的页数
	
	public StuResult() {
		this.stuResultDAO = new StuResultDAO();
	}
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		//page = request.getParameter("page");
		page = Integer.parseInt(request.getParameter("page"));
		System.out.println("page = "+page);
		System.out.println("StuResult获取的查询字符串：" + action);
		if (action == null || "".equals(action)) {
			return mapping.findForward("error");
		} else if ("stuResultQuery".equals(action)) {
			return stuResultQuery(mapping, form, request, response);
		} else if ("stuResultQueryS".equals(action)) {
			return stuResultQueryS(mapping, form, request, response);
		}
		request.setAttribute("error", "操作失败！");
		return mapping.findForward("error");
	}

	/*
	 *  管理员查询考生成绩
	 */
//	private ActionForward stuResultQuery(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response) {
//		if(form instanceof StuResultForm){
//			request.setAttribute("stuResultQuery", stuResultDAO.query(""));
//		}else{
//			QueryResultIfForm ifForm = (QueryResultIfForm) form;
//			request.setAttribute("stuResultQuery", stuResultDAO.query(ifForm));
//		}
//		return mapping.findForward("stuResultQuery");
//	}
	
	/*
	 *  管理员查询考生成绩
	 */
	private ActionForward stuResultQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(form instanceof StuResultForm){
			System.out.println("------查询考试全部成绩--------");
			request.setAttribute("stuResultQuery", stuResultDAO.queryByPage(page, pageSize));
			request.setAttribute("totalPages", stuResultDAO.getTotalPages(pageSize));
			request.setAttribute("page", page);
		}else{
			System.out.println("======根据条件模糊匹配查询=======");
			QueryResultIfForm ifForm = (QueryResultIfForm) form;
			request.setAttribute("stuResultQuery", stuResultDAO.query(ifForm));
			//request.setAttribute("totalPages", stuResultDAO.getTotalPages(pageSize));
			//request.setAttribute("page", page);
			//request.setAttribute("stuResultQuery", stuResultDAO.queryByPage(page, pageSize));			
		}
		return mapping.findForward("stuResultQuery");
	}
	
	/*
	 *  考生查询自己的成绩
	 */
	private ActionForward stuResultQueryS(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("stuResultQuery", stuResultDAO.query(request.getParameter("ID").toString()));
		return mapping.findForward("stuResultQueryS");
	}	
}