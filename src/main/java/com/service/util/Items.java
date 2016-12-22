package com.service.util;
import java.util.*;
//商品表
public class Items {
	private String id;//课程号
	private String name;//课程名
	private String grade;//年级
	private String subject;//科目
	private double price;//价格
	private Date update;//上传时间
	private String intro;//课程介绍
	private Date time;//上课时间
	private String teach_way;//教学方式
	private String tea_email;//老师电话
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getTeach_way() {
		return teach_way;
	}
	public void setTeach_way(String teach_way) {
		this.teach_way = teach_way;
	}
	public String getTea_email() {
		return tea_email;
	}
	public void setTea_email(String tea_email) {
		this.tea_email = tea_email;
	}

	
}