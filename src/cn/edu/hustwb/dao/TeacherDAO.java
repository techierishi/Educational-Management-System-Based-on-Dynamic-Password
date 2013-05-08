package cn.edu.hustwb.dao;

import java.util.List;

import cn.edu.hustwb.dto.Teacher;

public interface TeacherDAO {

	public abstract void save(Teacher transientInstance);

	public abstract void delete(Teacher persistentInstance);

	public abstract Teacher findById(java.lang.Integer id);

	public abstract List<Teacher> findByExample(Teacher instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Teacher merge(Teacher detachedInstance);

	public abstract void attachDirty(Teacher instance);

	public abstract void attachClean(Teacher instance);

}