package com.itstep.htmltip.entity;

public class Tip {
	int tipId;
	String title;
	String description;
	String exampleHtmlEscape;
	

	
	public Tip() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tip(int tipId, String title, String description, String exampleHtmlEscape) {
		super();
		this.tipId = tipId;
		this.title = title;
		this.description = description;
		this.exampleHtmlEscape = exampleHtmlEscape;
	}
	public Tip(String title, String description, String exampleHtmlEscape) {
		super();
		this.title = title;
		this.description = description;
		this.exampleHtmlEscape = exampleHtmlEscape;
	}
	public int getTipId() {
		return tipId;
	}
	public void setTipId(int tipId) {
		this.tipId = tipId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExampleHtmlEscape() {
		return exampleHtmlEscape;
	}
	public void setExampleHtmlEscape(String exampleHtmlEscape) {
		this.exampleHtmlEscape = exampleHtmlEscape;
	}
	
	
}
