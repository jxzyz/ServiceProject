package com.service.bean;

import java.util.Date;

public class Post {
	private String pos_eamil;
	private String pos_status;
	private Date pos_time;
	private String cou_id;
	private String pos_content;
	private int pos_good;
	public String getPos_eamil() {
		return pos_eamil;
	}
	public void setPos_eamil(String pos_eamil) {
		this.pos_eamil = pos_eamil;
	}
	public String getPos_status() {
		return pos_status;
	}
	public void setPos_status(String pos_status) {
		this.pos_status = pos_status;
	}
	public Date getPos_time() {
		return pos_time;
	}
	public void setPos_time(Date pos_time) {
		this.pos_time = pos_time;
	}
	public String getCou_id() {
		return cou_id;
	}
	public void setCou_id(String cou_id) {
		this.cou_id = cou_id;
	}
	public String getPos_content() {
		return pos_content;
	}
	public void setPos_content(String pos_content) {
		this.pos_content = pos_content;
	}
	public int getPos_good() {
		return pos_good;
	}
	public void setPos_good(int pos_good) {
		this.pos_good = pos_good;
	}
	
}
