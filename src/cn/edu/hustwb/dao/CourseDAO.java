package cn.edu.hustwb.dao;

import java.util.List;

import cn.edu.hustwb.dto.Course;

public interface CourseDAO {

	public abstract void save(Course transientInstance);

	public abstract void delete(Course persistentInstance);

	public abstract Course findById(java.lang.Integer id);

	public abstract List<Course> findByExample(Course instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Course merge(Course detachedInstance);

	public abstract void attachDirty(Course instance);

	public abstract void attachClean(Course instance);

}