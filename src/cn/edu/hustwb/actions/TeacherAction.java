package cn.edu.hustwb.actions;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.hustwb.dto.Student;
import cn.edu.hustwb.dto.Teacher;
import cn.edu.hustwb.services.TeacherService;
import cn.edu.hustwb.vo.TeacherVO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("teacher")
@Scope("prototype")
public class TeacherAction extends ActionSupport implements ModelDriven{
	private List<Teacher> teachers;
	private Teacher teacher;
	private TeacherService ts;
	private TeacherVO tvo = new TeacherVO();
	public String execute() throws Exception{
		return "success";
	}
	
	public String list(){		//列表
		this.teachers = this.ts.getTeachers();
		return "list";
	}
	public String listexample(){		//条件查询
		Teacher t = new Teacher();
		
		if(tvo.getTeaid()!=0){
			System.out.println(tvo.getTeaid());
			teacher = ts.findById(tvo.getTeaid());
			return "list";
		}
		if(!tvo.getTeaname().equals("")){
			t.setTeaname(tvo.getTeaname());
		}
		if(!tvo.getSex().equals("")){
			t.setSex(tvo.getSex());
		}
		if(!tvo.getDepartment().equals("")){
			t.setDepartment(tvo.getDepartment());
		}
		this.teachers = ts.findByExample(t);
		return "list";
	}
	public String find(){
		this.teacher = ts.findById(tvo.getTeaid());
		return "find";
	}
	public String update(){			//更新
		Teacher tea = new Teacher();
		tea.setTeaid(tvo.getTeaid());
		tea.setTeaname(tvo.getTeaname());
		tea.setDepartment(tvo.getDepartment());
		teacher=ts.update(tea);
		return "list";
	}
	public String delete(){		//删除
		Teacher tea = new Teacher();
		tea = ts.findById(tvo.getTeaid());
		ts.delete(tea);
		return "delete";
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public Object getModel() {
		return tvo;
	}
	
	
}
