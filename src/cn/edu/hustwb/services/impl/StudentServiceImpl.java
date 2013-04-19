package cn.edu.hustwb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hustwb.dao.impl.StudentDAOImpl;
import cn.edu.hustwb.dto.Student;
import cn.edu.hustwb.services.StudentService;

@Service("studentservice")
@Transactional(propagation = Propagation.REQUIRED)
public class StudentServiceImpl implements StudentService {
	private StudentDAOImpl studentdao;

	@Override
	public void save(Student transientInstance) {
		System.out.println("我是数据服务层");
		studentdao.save(transientInstance);
	}

	@Override
	public void delete(Student persistentInstance) {
		studentdao.delete(persistentInstance);
	}

	@Override
	public Student findById(java.lang.Integer id) {
		return studentdao.findById(id);
	}

	@Override
	public List findAll() {
		return studentdao.findAll();
	}

	@Override
	public Student merge(Student detachedInstance) {
		return studentdao.merge(detachedInstance);
	}

	@Autowired
	public void setStudentdao(StudentDAOImpl studentdao) {
		this.studentdao = studentdao;
	}

}
