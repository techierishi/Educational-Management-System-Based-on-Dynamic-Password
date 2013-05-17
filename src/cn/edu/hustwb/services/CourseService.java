package cn.edu.hustwb.services;

import java.util.List;

import cn.edu.hustwb.dto.Course;
import cn.edu.hustwb.dto.User;

public interface CourseService {

	void delete(Course persistentInstance);
	
	void add(Course transientInstance);
	
	
	Course findById(java.lang.Integer id);

	List<Course> findAll();

	Course merge(Course detachedInstance);
	
	 List<Course> findByExample(Course instance);
}
