package cn.edu.hustwb.actions;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.hustwb.dto.Teacher;
import cn.edu.hustwb.services.TeacherService;

import com.opensymphony.xwork2.ActionSupport;

@Component("teacher")
@Scope("prototype")
public class TeacherAction extends ActionSupport{
	private List<Teacher> teachers;
	private TeacherService ts;
	
	public String execute() throws Exception{
		return "success";
	}
	
	public String list(){
		this.teachers = this.ts.getTeachers();
		return "list";
	}
	
	
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public TeacherService getTs() {
		return ts;
	}
	@Resource
	public void setTs(TeacherService ts) {
		this.ts = ts;
	}
	
	
}
