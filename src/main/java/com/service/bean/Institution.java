package com.service.bean;

import java.util.Date;

public class Institution {
	private String ins_renum;
	private String ins_name;
	private String ins_password;
	private Date ins_join_date;
	private String ins_intro;
	private String ins_email;
	private String ins_state;
	public String getIns_renum() {
		return ins_renum;
	}
	public void setIns_renum(String ins_renum) {
		this.ins_renum = ins_renum;
	}
	public String getIns_name() {
		return ins_name;
	}
	public void setIns_name(String ins_name) {
		this.ins_name = ins_name;
	}
	public String getIns_password() {
		return ins_password;
	}
	public void setIns_password(String ins_password) {
		this.ins_password = ins_password;
	}
	
	public Date getIns_join_date() {
		return ins_join_date;
	}
	public void setIns_join_date(Date ins_join_date) {
		this.ins_join_date = ins_join_date;
	}
	public String getIns_intro() {
		return ins_intro;
	}
	public void setIns_intro(String ins_intro) {
		this.ins_intro = ins_intro;
	}
	public String getIns_email() {
		return ins_email;
	}
	public void setIns_email(String ins_email) {
		this.ins_email = ins_email;
	}
	public String getIns_state() {
		return ins_state;
	}
	public void setIns_state(String ins_state) {
		this.ins_state = ins_state;
	}
	
}
