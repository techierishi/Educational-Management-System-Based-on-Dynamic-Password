package cn.edu.hustwb.actions;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.hustwb.dto.Course;
import cn.edu.hustwb.dto.Score;
import cn.edu.hustwb.dto.ScoreId;
import cn.edu.hustwb.dto.Student;
import cn.edu.hustwb.dto.User;
import cn.edu.hustwb.services.CourseService;
import cn.edu.hustwb.services.ScoreService;
import cn.edu.hustwb.services.StudentService;

import com.opensymphony.xwork2.ActionSupport;

@Component("score")
@Scope("prototype")
public class ScoreAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private ScoreService scs;
	private StudentService ss;
	private CourseService cs;
	private int stuid;
	private int couid;
	private int usuallyscore;
	private int paperscore;
	private String couname;
	private String stuname;
	private String department;
	private String major;
	private String stuclass;
	private List<Score> scores;
	@Override
	public String execute() throws Exception{
		return "success";
	}
	
	public String add(){
		Score s = new Score();
		Course c = cs.findById(couid);
		Student t = ss.findById(stuid);
		ScoreId sid = new ScoreId(stuid, couid);
		s.setId(sid);
		s.setCourse(c);
		s.setStudent(t);
		s.setUsuallyscore(usuallyscore);
		s.setPaperscore(paperscore);
		s.setSumscore((int)(usuallyscore*0.3+paperscore*0.7));
		scs.add(s);
		return "add";
	}
	public String find(){  // 查找
		Score s = new Score();
		Course cou =new Course();
		Student stu = new Student();
		ScoreId sid = new ScoreId();
//		System.out.println("接收到的学生编号为:"+stuid+"接收到的课程编号为:"+couid);
		if(couid!=0){
			sid.setCouid(couid);
			s.setId(sid);
			cou = cs.findById(couid);
			s.setCourse(cou);
		}else if(!cou.equals("")){
			cou.setCouname(couname);
			s.setCourse(cou);
		}
		if(stuid!=0){
			sid.setStuid(stuid);
			s.setId(sid);
			stu = ss.findById(stuid);
			s.setStudent(stu);
		}else{
			if(!stuname.equals("")){
				stu.setStuname(stuname);
			}
			if(!department.equals("")){
				stu.setDepartment(department);
			}
			if(!major.equals("")){
				stu.setMajor(major);
				System.out.println(stu.getMajor());
			}
			if(!stuclass.equals("")){
				stu.setStuclass(stuclass);
			}
			if(!stuclass.equals("")||!major.equals("")||!stuname.equals("")||!department.equals("")){
				s.setStudent(stu);
			}
		}
		scores=scs.findByExample(s);
		return "list";
	}
	public String me(){  // 查询个人分数
		Score s = new Score();
		ScoreId sid = new ScoreId();
		User user = new User();
		user = (User) session.get("user");
		Student stu = ss.findById(user.getUserid());
		sid.setStuid(stu.getStuid());
		sid.setCouid(2);
//		s.setId(sid);
//		s.setStudent(stu);
//		s.setPaperscore(80);
//		s.setSumscore(86);
		s.setUsuallyscore(100);
//		System.out.println("sid:---->"+s.getId().getStuid()+"\n"						+"sname:----->"+s.getStudent().getStuname());
		scores=scs.findByExample(s);
		return "me";
	}
	
	public ScoreService getScs() {
		return scs;
	}
	@Resource
	public void setScs(ScoreService scs) {
		this.scs = scs;
	}
	public StudentService getSs() {
		return ss;
	}
	@Resource
	public void setSs(StudentService ss) {
		this.ss = ss;
	}
	public CourseService getCs() {
		return cs;
	}
	@Resource
	public void setCs(CourseService cs) {
		this.cs = cs;
	}
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public int getCouid() {
		return couid;
	}
	public void setCouid(int couid) {
		this.couid = couid;
	}
	public int getUsuallyscore() {
		return usuallyscore;
	}
	public void setUsuallyscore(int usuallyscore) {
		this.usuallyscore = usuallyscore;
	}
	public int getPaperscore() {
		return paperscore;
	}
	public void setPaperscore(int paperscore) {
		this.paperscore = paperscore;
	}

	public String getCouname() {
		return couname;
	}

	public void setCouname(String couname) {
		this.couname = couname;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getStuclass() {
		return stuclass;
	}

	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
