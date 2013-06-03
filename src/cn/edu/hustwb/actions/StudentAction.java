package cn.edu.hustwb.actions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.hustwb.dto.Student;
import cn.edu.hustwb.services.StudentService;
import cn.edu.hustwb.vo.StudentVO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("student")
@Scope("prototype")
public class StudentAction  extends ActionSupport  implements ModelDriven{
	private List<Student> students;
	private StudentService ss;
	private int sid;
	private Student student;
	private StudentVO svo = new StudentVO();
	public String execute() throws Exception{
		return "success";
	}
	
	public String list(){
		this.students = this.ss.getStudents();
		return "list";
	}
	public String listexample(){		//条件查询
		Student s = new Student();
		
		if(svo.getStuid()!=0){
			System.out.println(svo.getStuid());
			student = ss.findById(svo.getStuid());
			System.out.println(s.getStuid());

			return "list";
		}
		if(!svo.getStuname().equals("")){
			s.setStuname(svo.getStuname());
		}
		if(!svo.getSex().equals("")){
			s.setSex(svo.getSex());
		}
		if(!svo.getDepartment().equals("")){
			s.setDepartment(svo.getDepartment());
		}
		if(!svo.getMajor().equals("")){
			s.setMajor(svo.getMajor());
		}
		if(!svo.getNational().equals("")){
			s.setNational(svo.getNational());
		}

		this.students = ss.findByExample(s);
		return "list";
	}
	public String find(){
		this.student = ss.findById(this.sid);
		return "find";
	}
	public String update(){		//更新
		Student stu = new Student();
		stu.setStuid(svo.getStuid());
		stu.setBirdata(svo.getBirdata());
		stu.setDepartment(svo.getDepartment());
		stu.setMajor(svo.getMajor());
		stu.setNational(svo.getNational());
		stu.setSex(svo.getSex());
		stu.setStuname(svo.getStuname());
		stu.setAdtime(svo.getBirdata());
		stu.setStuclass(svo.getStuclass());

		this.student = ss.update(stu);
		return "list";
	}
	public String delete(){		//删除
		Student stu = new Student();
		stu = ss.findById(svo.getStuid());
		ss.delete(stu);;
		return "delete";
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

	@Override
	public Object getModel() {
		return svo;
	}

	public StudentVO getSvo() {
		return svo;
	}

	public void setSvo(StudentVO svo) {
		this.svo = svo;
	}


	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
