package com.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.service.bean.Student;

public interface StudentDAO {
	@Select("select * from student where stu_email=#{stu_email}")
	public Student getStuByStu_email(int stu_email);
	
	@Select("select * from student where stu_email=#{0} and stu_password=#{1}")
	public Student getStuByPhoAndPas(String stu_email, String stu_password);
	
	@Select("select * from student")
	public List<Student> getAllStu();
	
	@Insert("insert into student values(#{stu_email}, #{stu_nickname}, #{stu_password}, #{stu_sex}, #{stu_name}, #{stu_level}, #{stu_inter)")
	public void insertStu(Student student);
	
	@Delete("delete from student where stu_email=#{stu_email}")
	public void deleteStuByStu_email(String stu_email);
	
}
