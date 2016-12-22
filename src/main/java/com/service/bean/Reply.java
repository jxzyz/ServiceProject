package com.service.bean;

import java.util.Date;

public class Reply {
	private String rep_email;
	private String rep_status;
	private Date rep_time;
	private String pos_email;
	private String cou_id;
	private Date pos_time;
	private String rep_content;
	private int rep_good;
	public String getRep_email() {
		return rep_email;
	}
	public void setRep_email(String rep_email) {
		this.rep_email = rep_email;
	}
	public String getRep_status() {
		return rep_status;
	}
	public void setRep_status(String rep_status) {
		this.rep_status = rep_status;
	}
	public Date getRep_time() {
		return rep_time;
	}
	public void setRep_time(Date rep_time) {
		this.rep_time = rep_time;
	}
	public String getPos_email() {
		return pos_email;
	}
	public void setPos_email(String pos_email) {
		this.pos_email = pos_email;
	}
	public String getCou_id() {
		return cou_id;
	}
	public void setCou_id(String cou_id) {
		this.cou_id = cou_id;
	}
	public Date getPos_time() {
		return pos_time;
	}
	public void setPos_time(Date pos_time) {
		this.pos_time = pos_time;
	}
	public String getRep_content() {
		return rep_content;
	}
	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}
	public int getRep_good() {
		return rep_good;
	}
	public void setRep_good(int rep_good) {
		this.rep_good = rep_good;
	}
	
}
