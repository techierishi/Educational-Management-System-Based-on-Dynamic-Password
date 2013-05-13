package cn.edu.hustwb.util.test;

import org.junit.Test;

import cn.edu.hustwb.dao.UserDAO;
import cn.edu.hustwb.dao.impl.UserDAOImpl;
import cn.edu.hustwb.dto.User;

public class HibernateUtilTest {

	@Test
	public void test() {
		UserDAO userdao = new UserDAOImpl(); 
		User u = new User();
		u.setAccount("durui");
		u.setPassword("durui123");
		System.out.println(userdao.login(u));
	}

}
 