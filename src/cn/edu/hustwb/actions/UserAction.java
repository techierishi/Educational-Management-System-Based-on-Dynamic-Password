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
	private String result =""; 
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

	public String login(){			//登录
		User user = new User();
		user.setAccount(uvo.getAccount());
		user.setPassword(uvo.getPassword());
		System.out.println("UserAction中的login方法，动态密码参数接收:"+uvo.getEkey());
		if (us.login(user,uvo.getEkey())) { 
			user = us.findByExample(user).get(0); //拿到User 对象
			System.out.println("UserAction中通过findByExample拿到对象"+user.getUserid());
			session.put("user",user );
			if (user.getType() == 3) {
				return "loginSuccess";
			} else if (user.getType() == 2) {
				return "loginSuccesst";
			} else if (user.getType() == 1) {
				return "loginSuccesss";
			} else
				return "loginFalse";
		} else {
			return "loginFalse";
		}
	}

	public String login2(){			//extjs登录
		User user = new User();
		user.setAccount(uvo.getAccount());
		user.setPassword(uvo.getPassword());
		System.out.println("UserAction中的login方法，动态密码参数接收:"+uvo.getEkey());
		
		if (us.login(user,uvo.getEkey())) { 
			user = us.findByExample(user).get(0); //拿到User 对象
			System.out.println("UserAction中通过findByExample拿到对象"+user.getUserid());
			session.put("user",user );
			result = "{success : true,text : \"登录成功!\"}";  
			return "loginSuccess";
		} else {
			result = "{failure : true,text : \"密码错误!\"}";  
			return "loginFalse";
		}
	}
	
	public String register(){			//注册
		if (uvo.getPassword().equals(uvo.getPassword2())) {
			System.out.println("成功，返回success");
			User user = new User();
			user.setAccount(uvo.getAccount());
			user.setPassword(uvo.getPassword());
			user.setType(uvo.getType());
			user.setStatus(uvo.getStatus());
			user.setPermissions(uvo.getPermissions());
			user.setEkey(uvo.getEkey());
			us.add(user);
			if(uvo.getType()==1){
//				new 一个 学生
				Student student = new Student();
				student.setStuid(us.findByExample(user).get(0).getUserid());
				System.out.println(us.findByExample(user).get(0).getUserid());
				student.setStuname(uvo.getUsername());
				student.setSex(uvo.getSex());
				ss.add(student);
			}else if(uvo.getType()==2){
//				new 一个教师
				Teacher teacher = new Teacher();
				teacher.setTeaid(us.findByExample(user).get(0).getUserid());
				teacher.setTeaname(uvo.getUsername());
				teacher.setSex(uvo.getSex());
				ts.add(teacher);
			}
			
			return "registersuccess";
		}
	
		return "registerfail";
	}
	public String list(){				//查询
		this.users = this.us.getUsers();
		return "list";
	}
	
	public String listexample(){		//条件查询
		User u = new User();
		if(!(uvo.getAccount().equals(null)||uvo.getAccount().equals(""))){
			u.setAccount(uvo.getAccount());
		}
		if(uvo.getType()!=-1){
			u.setType(uvo.getType());
		}
		this.users = us.findByExample(u);
		return "list";
	}
	
	public String update(){				//修改数据
		User user = new User();
		user.setUserid(uvo.getUserid());
 		user.setAccount(uvo.getAccount());
		user.setPassword(uvo.getPassword());
		user.setType(uvo.getType());
		user.setStatus(uvo.getStatus());
		user.setPermissions(uvo.getPermissions());
		user.setEkey(uvo.getEkey());
		us.merge(user);
		return "update";
	}
	
	public String updateme(){				//修改动态密码
		User user = new User();
		user = (User) session.get("user");
		user.setEkey(uvo.getEkey());
		us.merge(user);
		return "updateme";
	}
	public String updatepwd(){				//修改密码
		User user = new User();
		user = (User) session.get("user");
		if(uvo.getPassword().equals(uvo.getPassword2())){
			user.setPassword(uvo.getPassword());
			us.merge(user);
			return "updatepwd";
		}
		return "updatepwdfalse";
	}
	
	public String delete(){			//删除用户
		User user = us.findById(uvo.getUserid());
		us.delete(user);
		return "delete";
	}
	public String logout(){			//登出
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
