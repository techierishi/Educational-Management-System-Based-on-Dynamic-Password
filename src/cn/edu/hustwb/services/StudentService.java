package cn.edu.hustwb.services;

import java.util.List;

import cn.edu.hustwb.dto.Student;

public interface StudentService {
	void add(Student transientInstance);
	List findAll();
	public List<Student>getStudents();
}