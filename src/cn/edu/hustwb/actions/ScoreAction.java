package cn.edu.hustwb.actions;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.hustwb.dto.Course;
import cn.edu.hustwb.dto.Score;
import cn.edu.hustwb.dto.ScoreId;
import cn.edu.hustwb.dto.Student;
import cn.edu.hustwb.services.CourseService;
import cn.edu.hustwb.services.ScoreService;
import cn.edu.hustwb.services.StudentService;

import com.opensymphony.xwork2.ActionSupport;

@Component("score")
@Scope("prototype")
public class ScoreAction extends ActionSupport{
	private ScoreService scs;
	private StudentService ss;
	private CourseService cs;
	private int stuid;
	private int couid;
	private int usuallyscore;
	private int paperscore;
	
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

}
