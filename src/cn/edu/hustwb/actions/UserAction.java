package cn.edu.hustwb.actions;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.hustwb.dto.Student;
import cn.edu.hustwb.dto.Teacher;
import cn.edu.hustwb.dto.User;
import cn.edu.hustwb.services.StudentService;
import cn.edu.hustwb.services.TeacherService;
import cn.edu.hustwb.services.UserService;
import cn.edu.hustwb.vo.UserVO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Component("user")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven,RequestAware,SessionAware,ApplicationAware {
	
	private UserVO uvo = new UserVO();
	private UserService us;
	private StudentService ss;
	private TeacherService ts;
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;
	private List<User> users;
	public UserService getUs() {
		return us;
	}

	@Resource
	public void setUs(UserService us) {
		this.us = us;
	}

	@Override
	public String execute() throws Exception{
		return "success";
	}

	public String login(){
		System.out.println("我是UserAction方法的login~!~!~");
		User user = new User();
		user.setAccount(uvo.getAccount());
		user.setPassword(uvo.getPassword());
		System.out.println(user.getAccount());
		if (us.login(user)) {
			session.put("user",user );
			return "loginSuccess";
		} else {
			return "loginFalse";
		}
	}
	
	
	public String register(){
		System.out.println("我是action~!~!~!~!~!~!~!~!~!~");
		System.out.println(uvo.getAccount());
		System.out.println(uvo.getPassword());
		System.out.println(uvo.getPermissions());
		System.out.println(uvo.getStatus());
		System.out.println(uvo.getType());
		System.out.println(uvo.getEkey());
		
		if (uvo.getPassword().equals(uvo.getPassword2())) {
			System.out.println("成功，返回success");
			
			if(uvo.getType()==1){
				System.out.println(11111);
//				new 一个 学生
				Student student = new Student();
				student.setStuname(uvo.getUsername());
				student.setSex(uvo.getSex());
				ss.add(student);
			}else if(uvo.getType()==2){
				System.out.println(2222);
//				new 一个教师
				Teacher teacher = new Teacher();
				teacher.setTeaname(uvo.getUsername());
				teacher.setSex(uvo.getSex());
				ts.add(teacher);
			}
			User user = new User();
			user.setAccount(uvo.getAccount());
			user.setPassword(uvo.getPassword());
			user.setType(uvo.getType());
			user.setStatus(uvo.getStatus());
			user.setPermissions(uvo.getPermissions());
			user.setEkey(uvo.getEkey());
			us.add(user);
			return "registersuccess";
		}
	
		return "registerfail";
	}
	public String list(){
		this.users = this.us.getUsers();
		return "list";
	}
	
	public String logout(){
		session.remove("user");
		return "login";
	}
	
	public UserVO getUvo() {
		return uvo;
	}

	public void setUvo(UserVO uvo) {
		this.uvo = uvo;
	}
	

	@Override
	public Object getModel() {
		return uvo;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public StudentService getSs() {
		return ss;
	}
	@Resource
	public void setSs(StudentService ss) {
		this.ss = ss;
	}

	public TeacherService getTs() {
		return ts;
	}
	@Resource
	public void setTs(TeacherService ts) {
		this.ts = ts;
	}


	
}
