package cn.edu.hustwb.services;

import java.util.List;

import cn.edu.hustwb.dto.User;

public interface UserService {


	void delete(User persistentInstance);
	
	void add(User transientInstance);
	
	boolean login(User transientInstance,String key);
	
	User findById(java.lang.Integer id);

	List findAll();

	User merge(User detachedInstance);
	
	 List<User>getUsers();
	 List<User> findByExample(User instance);
}
