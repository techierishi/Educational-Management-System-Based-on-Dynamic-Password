package cn.edu.hustwb.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hustwb.dao.StudentDAO;
import cn.edu.hustwb.dto.Student;
import cn.edu.hustwb.services.StudentService;


@Service("studentService")
@Transactional(propagation = Propagation.REQUIRED)
public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDao;

	
	public StudentDAO getStudentDao() {
		return studentDao;
	}
	@Resource
	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}
	@Override
	public void add(Student st) {
		System.out.println("studentServiceImpl调用add()方法");
		studentDao.save(st);
	}
	@Override
	public void delete(Student st){
		studentDao.delete(st);
	}
	@Override
	public List findAll() {
		return studentDao.findAll();
	}
	@Override
	public List<Student> getStudents() {
		return studentDao.findAll();
	}
	@Override
	public Student findById(int id) {
		return studentDao.findById(id);
	}
	@Override
	public Student update(Student student) {
		return studentDao.merge(student);
	}
	@Override
	public List<Student> findByExample(Student s) {
		
		return studentDao.findByExample(s);
	}

}
