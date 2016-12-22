package com.service.bean;

import java.util.Date;

public class Section {
	private String cou_id;
	private int sec_num;
	private String sec_intro;
	private Date sec_time;
	private String sec_homework;
	private String sec_home_ans;
	public String getCou_id() {
		return cou_id;
	}
	public void setCou_id(String cou_id) {
		this.cou_id = cou_id;
	}
	public int getSec_num() {
		return sec_num;
	}
	public void setSec_num(int sec_num) {
		this.sec_num = sec_num;
	}
	public String getSec_intro() {
		return sec_intro;
	}
	public void setSec_intro(String sec_intro) {
		this.sec_intro = sec_intro;
	}
	public Date getSec_time() {
		return sec_time;
	}
	public void setSec_time(Date sec_time) {
		this.sec_time = sec_time;
	}
	public String getSec_homework() {
		return sec_homework;
	}
	public void setSec_homework(String sec_homework) {
		this.sec_homework = sec_homework;
	}
	public String getSec_home_ans() {
		return sec_home_ans;
	}
	public void setSec_home_ans(String sec_home_ans) {
		this.sec_home_ans = sec_home_ans;
	}
	
}
