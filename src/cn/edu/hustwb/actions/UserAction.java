package cn.edu.hustwb.actions;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.hustwb.dto.User;
import cn.edu.hustwb.services.UserService;
import cn.edu.hustwb.vo.UserVO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Component("user")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven,RequestAware,SessionAware,ApplicationAware {
	
	private UserVO uvo = new UserVO();
	private UserService us;
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;
	
	public UserService getUs() {
		return us;
	}

	@Resource
	public void setUs(UserService us) {
		this.us = us;
	}

	@Override
	public String execute() throws Exception{
		System.out.println("我是action~!~!~!~!~!~!~!~!~!~");
		System.out.println(uvo.getAccount());
		System.out.println(uvo.getPassword());
		User user = new User();
		user.setAccount(uvo.getAccount());
		user.setPassword(uvo.getPassword());
		if (uvo.getPassword().equals(uvo.getPassword2())) {
			System.out.println("成功，返回success");
			us.add(user);
			return "success";
		}
		return "fail";
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


	
}
