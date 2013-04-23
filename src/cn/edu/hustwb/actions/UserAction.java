package cn.edu.hustwb.actions;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import cn.edu.hustwb.dto.User;
import cn.edu.hustwb.services.UserService;
import cn.edu.hustwb.vo.UserVO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("user")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven{
	
	private UserVO uvo = new UserVO();

	private UserService us;
	
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
	
}
