package cn.edu.hustwb.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hustwb.dao.UserDAO;
import cn.edu.hustwb.dto.User;
import cn.edu.hustwb.services.UserService;
import cn.edu.hustwb.util.DynamicEncrypt;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	private UserDAO userDao;
	
	public UserDAO getUserDao() {
		return userDao;
	}
//	@Autowired
	@Resource
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	public boolean login(User u,String key){
		if (userDao.login(u)) {
			List<User> listuser =userDao.findByExample(u);
			for(int i=0;i<listuser.size();i++){
				if(listuser.get(i).getEkey()!=null&&!listuser.get(i).getEkey().equals("")){			//该账户已经设置了动态密码且 不为空
					System.out.println("动态密码不为空");
					
					DynamicEncrypt de = new DynamicEncrypt();
					if(!de.ServerValid(listuser.get(i).getEkey(), key)){				//密码验证
						System.out.println("动态密码验证失败");
						return false;
					}else {
						System.out.println("动态密码验证成功");
						return true;
					}
				}else {
					System.out.println("并未设置动态密码");
				}
			}
			System.out.println("未设置动态密码登陆成功");
			return true;
		} 
		return false;
	}
	
	@Override
	public void add(User u) {
		userDao.save(u);
	}


	@Override
	public void delete(User u) {
		userDao.delete(u);
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
	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}
	
	
	@Override
	public List<User> findByExample(User user) {
		return userDao.findByExample(user);
	}

}
