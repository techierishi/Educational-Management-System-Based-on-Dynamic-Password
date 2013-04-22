package cn.edu.hustwb.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.edu.hustwb.dto.Student;
import cn.edu.hustwb.services.StudentService;

import com.opensymphony.xwork2.ActionSupport;

@Controller("studentAction")
public class StudentAction extends ActionSupport {
	private Student stu;
	private StudentService service;

	@Autowired
	public void setService(StudentService service) {
		this.service = service;
		
	}

	public Student getStu() {
		
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	} 

	public String save() {
		System.out.println(stu);
		System.out.println("我是业务逻辑层");
		service.save(stu);

		return this.SUCCESS;
	}

}
