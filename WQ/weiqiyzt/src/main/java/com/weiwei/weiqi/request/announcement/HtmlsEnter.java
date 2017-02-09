package com.weiwei.weiqi.request.announcement;

import javax.validation.constraints.NotNull;

import com.weiwei.weiqi.request.base.BaseEnter;

public class HtmlsEnter extends BaseEnter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 13190634160089389L;
	private String title;
	private Short typeid;  //22表示政策
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Short getTypeid() {
		return typeid;
	}
	public void setTypeid(Short typeid) {
		this.typeid = typeid;
	}
	
	
	
}
