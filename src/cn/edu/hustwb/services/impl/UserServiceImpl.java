package cn.edu.hustwb.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hustwb.dao.UserDAO;
import cn.edu.hustwb.dto.User;
import cn.edu.hustwb.services.UserService;

@Service("userservice")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	private UserDAO userDao;

	@Override
	public void save(User u) {
		userDao.save(u);
	}
 
	@Override
	public void delete(User u) {
		userDao.delete(u);
	}
	
	@Override
	public void add(User u) {
		userDao.save(u);
	}

	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public List findAll() {
		return  userDao.findAll();
	}

	@Override
	public User merge(User u) {
		return this.userDao.merge(u);
	}
	
	@Autowired
	public void setUserdao(UserDAO userDao) {
		this.userDao = userDao;
	}

/*	@Resource
	public void setUserdao(UserDAO userDao) {
		this.userDao = userDao;
	}*/
}
