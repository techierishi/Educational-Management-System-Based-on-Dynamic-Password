package cn.edu.hustwb.services;

import java.util.List;

import cn.edu.hustwb.dto.Student;

public interface StudentService {

	void save(Student transientInstance);

	void delete(Student persistentInstance);

	Student findById(java.lang.Integer id);

	List findAll();

	Student merge(Student detachedInstance);

}
