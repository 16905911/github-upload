package com.oes.actionForm;

import org.apache.struts.action.ActionForm;

/*
 * @ ��ѯ�ɼ�����ϸ��Ϣ
 * 
 */

public class QueryResultIfForm extends ActionForm  {
	
	private String queryIf;   //��ѯѡ����Ӧ���ֶ�
	private String key;       //��ѯ�ı���������ֶ�

	public String getQueryIf() {
		return queryIf;
	}
	public void setQueryIf(String queryIf) {
		this.queryIf = queryIf;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
