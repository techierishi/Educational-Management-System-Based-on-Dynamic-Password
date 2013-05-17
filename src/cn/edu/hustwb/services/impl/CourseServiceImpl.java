package cn.edu.hustwb.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hustwb.dao.CourseDAO;
import cn.edu.hustwb.dto.Course;
import cn.edu.hustwb.dto.User;
import cn.edu.hustwb.services.CourseService;
@Service("courseService")
@Transactional(propagation = Propagation.REQUIRED)
public class CourseServiceImpl implements CourseService {
	private CourseDAO courseDao;
	@Override
	public void delete(Course persistentInstance) {
		courseDao.delete(persistentInstance);
	}

	@Override
	public void add(Course c) {
		courseDao.save(c);
	}

	@Override
	public Course findById(Integer id) {
		return courseDao.findById(id);
	}

	@Override
	public List<Course> findAll() {
		return courseDao.findAll();
	}

	@Override
	public Course merge(Course detachedInstance) {
		return courseDao.merge(detachedInstance);
	}

	@Override
	public List<Course> findByExample(Course instance) {
		return null;
	}

	public CourseDAO getCourseDao() {
		return courseDao;
	}
	@Resource
	public void setCourseDao(CourseDAO courseDao) {
		this.courseDao = courseDao;
	}

}
