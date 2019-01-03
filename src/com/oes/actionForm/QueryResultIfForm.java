package com.oes.actionForm;

import org.apache.struts.action.ActionForm;

/*
 * @ 查询成绩的详细信息
 * 
 */

public class QueryResultIfForm extends ActionForm  {
	
	private String queryIf;   //查询选择框对应的字段
	private String key;       //查询文本框输入的字段

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
