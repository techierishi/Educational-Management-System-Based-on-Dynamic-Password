package cn.edu.hustwb.actions;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.hustwb.dto.Score;
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
	
	public String find(){
		student = ss.findById(this.sid);
		return "find";
	}
	public String update(){
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

		ss.update(stu);
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
