package cn.edu.hustwb.services.impl.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import cn.edu.hustwb.dto.User;
import cn.edu.hustwb.services.UserService;
import cn.edu.hustwb.services.impl.UserServiceImpl;



public class UserServiceImplTest {

	@Test
	public void testSave() {
		UserService um = new UserServiceImpl(); 
		User u = new User();
		u.setAccount("123");
		u.setPassword("b");
		um.save(u);
	}
	@Test
	public void testAdd() {
		UserService um = new UserServiceImpl(); 
		User u = new User();
		u.setAccount("123");
		u.setPassword("b");
		um.save(u);
	}
	@Test
	public void testDelete() {
		System.out.println("123");
		
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testMerge() {
		fail("Not yet implemented");
	}

}
