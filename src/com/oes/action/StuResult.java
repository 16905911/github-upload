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
	private int pageSize = 10; //һҳ��ʾ�ļ�¼�� 
	private int page ; //Ĭ����ʾ��ҳ��
	
	public StuResult() {
		this.stuResultDAO = new StuResultDAO();
	}
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		//page = request.getParameter("page");
		page = Integer.parseInt(request.getParameter("page"));
		System.out.println("page = "+page);
		System.out.println("StuResult��ȡ�Ĳ�ѯ�ַ�����" + action);
		if (action == null || "".equals(action)) {
			return mapping.findForward("error");
		} else if ("stuResultQuery".equals(action)) {
			return stuResultQuery(mapping, form, request, response);
		} else if ("stuResultQueryS".equals(action)) {
			return stuResultQueryS(mapping, form, request, response);
		}
		request.setAttribute("error", "����ʧ�ܣ�");
		return mapping.findForward("error");
	}

	/*
	 *  ����Ա��ѯ�����ɼ�
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
	 *  ����Ա��ѯ�����ɼ�
	 */
	private ActionForward stuResultQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(form instanceof StuResultForm){
			System.out.println("------��ѯ����ȫ���ɼ�--------");
			request.setAttribute("stuResultQuery", stuResultDAO.queryByPage(page, pageSize));
			request.setAttribute("totalPages", stuResultDAO.getTotalPages(pageSize));
			request.setAttribute("page", page);
		}else{
			System.out.println("======��������ģ��ƥ���ѯ=======");
			QueryResultIfForm ifForm = (QueryResultIfForm) form;
			request.setAttribute("stuResultQuery", stuResultDAO.query(ifForm));
			//request.setAttribute("totalPages", stuResultDAO.getTotalPages(pageSize));
			//request.setAttribute("page", page);
			//request.setAttribute("stuResultQuery", stuResultDAO.queryByPage(page, pageSize));			
		}
		return mapping.findForward("stuResultQuery");
	}
	
	/*
	 *  ������ѯ�Լ��ĳɼ�
	 */
	private ActionForward stuResultQueryS(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("stuResultQuery", stuResultDAO.query(request.getParameter("ID").toString()));
		return mapping.findForward("stuResultQueryS");
	}	
}