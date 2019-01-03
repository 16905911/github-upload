package com.oes.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.oes.actionForm.TaoTiForm;
import com.oes.dao.LessonDAO;
import com.oes.dao.TaoTiDAO;

public class TaoTi extends Action {
	private TaoTiDAO taoTiDAO = null;
	private LessonDAO lessonDAO=null;

	public TaoTi() {
		this.taoTiDAO = new TaoTiDAO();
		this.lessonDAO=new LessonDAO();
	}
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		System.out.println("TaoTi��ȡ�Ĳ�ѯ�ַ�����" + action);
		if (action == null || "".equals(action)) {
			return mapping.findForward("error");
		} else if ("taoTiQuery".equals(action)) {
			return taoTiQuery(mapping, form, request, response);
		}else if("taoTiAddQuery".equals(action)){
			return taoTiAddQuery(mapping,form,request,response);			
		} else if ("taoTiAdd".equals(action)) {
			return taoTiAdd(mapping, form, request, response);
		} else if ("taoTiDel".equals(action)) {
			return taoTiDel(mapping, form, request, response);
		}else if("taoTiModifyQuery".equals(action)){
			return taoTiModifyQuery(mapping,form,request,response);
		}else if("taoTiModify".equals(action)){
			return taoTiModify(mapping,form,request,response);
		}
		request.setAttribute("error", "����ʧ�ܣ�");
		return mapping.findForward("error");
	}

	/*
	 *  ��ѯ�Ծ���Ϣ
	 */
	private ActionForward taoTiQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("taoTiQuery", taoTiDAO.query(0));
		return mapping.findForward("taoTiQuery");
	}

	/*
	 *  ����Ծ�
	 */
	private ActionForward taoTiAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TaoTiForm taoTiForm = (TaoTiForm) form;
		int ret = taoTiDAO.insert(taoTiForm);
		System.out.println("taoTiAdd����ֵret��" + ret);
		if (ret == 1) {
			return mapping.findForward("taoTiAdd");
		} else if (ret == 2) {
			request.setAttribute("error", "���Ծ��Ѿ���ӣ�");
			return mapping.findForward("error");
		} else {
			request.setAttribute("error", "����Ծ�ʧ�ܣ�");
			return mapping.findForward("error");
		}
	}
	
	/*
	 *  ����Ծ�ʱ��ѯ
	 */
	private ActionForward taoTiAddQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("lessonList",lessonDAO.query(0));	//ȫ����Ŀ�б�
		return mapping.findForward("taoTiAddQuery");
	}
	
	/*
	 *  �޸��Ծ�ʱ��ѯ
	 */
	private ActionForward taoTiModifyQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TaoTiForm taoTiForm=(TaoTiForm)((taoTiDAO.query(Integer.parseInt(request.getParameter("id")))).get(0));
		request.setAttribute("taoTiModifyQuery", taoTiForm);
		request.setAttribute("lessonList",lessonDAO.query(0));	//ȫ����Ŀ�б�
		return mapping.findForward("taoTiModifyQuery");
	}
	
	/*
	 * �޸��Ծ�
	 */
	private ActionForward taoTiModify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TaoTiForm taoTiForm = (TaoTiForm) form;
		int ret = taoTiDAO.update(taoTiForm);
		if (ret == 0) {
			request.setAttribute("error", "�޸��Ծ�ʧ�ܣ�");
			return mapping.findForward("error");
		} else {
			return mapping.findForward("taoTiModify");
		}
	}	
	
	/*
	 *  ɾ���Ծ�
	 */
	private ActionForward taoTiDel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TaoTiForm taoTiForm = (TaoTiForm) form;
		int ret = taoTiDAO.delete(taoTiForm);
		if (ret == 0) {
			request.setAttribute("error", "ɾ���Ծ�ʧ�ܣ�");
			return mapping.findForward("error");
		} else {
			return mapping.findForward("taoTiDel");
		}
	}
}