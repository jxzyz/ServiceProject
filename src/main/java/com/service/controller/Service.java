package com.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.bean.Student;
import com.service.dao.StudentDAO;
import com.service.factory.MyBeansFactory;

//Controller的声明
@Controller
public class Service {
	
	//Example:
	//url为stu_login.do时，自动转入此函数
	@RequestMapping("/stu_login")
	//同名的form表单参数可自动赋值
	public String stu_login(String stu_email, String stu_password, Model model){
		//通过相应bean id获取DAO类
		StudentDAO stuDAO = (StudentDAO)MyBeansFactory.getBeans("studentdao");
		//从数据库中获取相应数据，可在com.service.dao包中自定义SQL语句
		Student student = stuDAO.getStuByPhoAndPas(stu_email, stu_password);
		if(student != null){
			//自定义返回界面
			return "welcome.html";
		}
		else{
			//自定义返回界面
			return "error.html";
		}
			
	}
}
