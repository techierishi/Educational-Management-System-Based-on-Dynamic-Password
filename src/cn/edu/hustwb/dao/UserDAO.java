package cn.edu.hustwb.dao;

import java.util.List;

import cn.edu.hustwb.dto.User;

public interface UserDAO {

	public abstract void save(User transientInstance);

	public abstract void delete(User persistentInstance);
	
	public abstract void update(User persistentInstance);
	
	public abstract boolean login(User persistentInstance);
	
	public abstract User findById(java.lang.Integer id);

	public abstract List<User> findByExample(User instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract User merge(User detachedInstance);

	public abstract void attachDirty(User instance);

	public abstract void attachClean(User instance);

}