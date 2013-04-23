package cn.edu.hustwb.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.hustwb.dto.Student;
import cn.edu.hustwb.services.StudentService;

import com.opensymphony.xwork2.ActionSupport;

@Controller("student")
@Scope("prototype")
public class StudentAction extends ActionSupport {
	private StudentService ss;

	@Autowired
	public void setService(StudentService service) {
		this.ss = service;
		
	}

	public String save() {
		System.out.println("我是业务逻辑层");

		return this.SUCCESS;
	}

	public StudentService getSs() {
		return ss;
	}
	
	@Autowired
	public void setSs(StudentService ss) {
		this.ss = ss;
	}

}
