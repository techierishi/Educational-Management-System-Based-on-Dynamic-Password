package cn.edu.hustwb.actions;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.hustwb.dto.Course;
import cn.edu.hustwb.dto.Teacher;
import cn.edu.hustwb.dto.User;
import cn.edu.hustwb.services.CourseService;
import cn.edu.hustwb.services.TeacherService;

import com.opensymphony.xwork2.ActionSupport;
@Component("course")
@Scope("prototype")
public class CourseAction extends ActionSupport {
	private CourseService cs;
	private TeacherService ts;
	private int teacherid;
	private String couname;
	
	private List<Course> courselist;
	
	@Override
	public String execute() throws Exception{
		return "success";
	}
	
	public String list(){			//列表
		courselist= cs.findAll();
		return "list";
	}
	
	public String add(){			//添加课程
		System.out.println(teacherid+"教师编号");
		Teacher tea = ts.findById(teacherid);
		Course c = new Course();
		c.setCouname(couname);
		c.setTeacher(tea);
		cs.add(c);
		return "add";
	}
	
	public String delete(){
		cs.delete(cs.findById(teacherid));
		return "delete";
	}
	public CourseService getCs() {
		return cs;
	}
	@Resource
	public void setCs(CourseService cs) {
		this.cs = cs;
	}
	public TeacherService getTs() {
		return ts;
	}
	@Resource
	public void setTs(TeacherService ts) {
		this.ts = ts;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public String getCouname() {
		return couname;
	}

	public void setCouname(String couname) {
		this.couname = couname;
	}

	public List<Course> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}
}
