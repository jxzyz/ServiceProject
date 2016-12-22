package com.service.bean;

import java.util.Date;

public class File {
	private String fil_id;
	private String cou_id;
	private Date fil_up_date;
	public String getFil_id() {
		return fil_id;
	}
	public void setFil_id(String fil_id) {
		this.fil_id = fil_id;
	}
	public String getCou_id() {
		return cou_id;
	}
	public void setCou_id(String cou_id) {
		this.cou_id = cou_id;
	}
	public Date getFil_up_date() {
		return fil_up_date;
	}
	public void setFil_up_date(Date fil_up_date) {
		this.fil_up_date = fil_up_date;
	}
	
}
