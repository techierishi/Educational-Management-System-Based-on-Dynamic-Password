package cn.edu.hustwb.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hustwb.dao.TeacherDAO;
import cn.edu.hustwb.dto.Teacher;
import cn.edu.hustwb.services.TeacherService;

@Service("teacherService")
@Transactional(propagation = Propagation.REQUIRED)
public class TeacherServiceImpl implements TeacherService {
	private TeacherDAO teacherDao;

	public TeacherDAO getTeacherDao() {
		return teacherDao;
	}
	@Resource
	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public void add(Teacher tea) {
		teacherDao.save(tea);
	}
	
	@Override
	public List findAll() {
		return teacherDao.findAll();
	}
	@Override
	public List<Teacher> getTeachers() {
		System.out.println("ts中的list方法");
		return teacherDao.findAll();
	}
	@Override
	public Teacher findById(int id) {
		return teacherDao.findById(id);
	}

}
