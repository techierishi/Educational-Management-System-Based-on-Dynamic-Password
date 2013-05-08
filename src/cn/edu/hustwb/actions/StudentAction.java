package cn.edu.hustwb.actions;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.hustwb.dto.Student;
import cn.edu.hustwb.services.StudentService;

import com.opensymphony.xwork2.ActionSupport;
@Component("student")
@Scope("prototype")
public class StudentAction  extends ActionSupport{
	private List<Student> students;
	private StudentService ss;
	
	
	public String execute() throws Exception{
		return "success";
	}
	
	public String list(){
		this.students = this.ss.getStudents();
		return "list";
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public StudentService getSs() {
		return ss;
	}
	
	@Resource
	public void setSs(StudentService ss) {
		this.ss = ss;
	}
}
