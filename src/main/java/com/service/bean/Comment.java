package com.service.bean;

import java.util.Date;

public class Comment {
	private String stu_email;
	private String cou_id;
	private String com_text;
	private Date com_date;
	private float com_star;
	public String getStu_email() {
		return stu_email;
	}
	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}
	public String getCou_id() {
		return cou_id;
	}
	public void setCou_id(String cou_id) {
		this.cou_id = cou_id;
	}
	public String getCom_text() {
		return com_text;
	}
	public void setCom_text(String com_text) {
		this.com_text = com_text;
	}
	public Date getCom_date() {
		return com_date;
	}
	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}
	public float getCom_star() {
		return com_star;
	}
	public void setCom_star(float com_star) {
		this.com_star = com_star;
	}
	
	
}
