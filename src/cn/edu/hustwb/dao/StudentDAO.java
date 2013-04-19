package cn.edu.hustwb.dao;

import java.util.List;

import cn.edu.hustwb.dto.Student;

public interface StudentDAO {

	public abstract void save(Student transientInstance);

	public abstract void delete(Student persistentInstance);

	public abstract Student findById(java.lang.Integer id);

	public abstract List<Student> findByExample(Student instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Student merge(Student detachedInstance);

	public abstract void attachDirty(Student instance);

	public abstract void attachClean(Student instance);

}