package cn.edu.hustwb.services;

import java.util.List;

import cn.edu.hustwb.dto.Teacher;

public interface TeacherService {

	public abstract void add(Teacher tea);
	public List<Teacher>getTeachers();
	List findAll();
	Teacher findById(int id);
	public  List<Teacher> findByExample(Teacher t);
	 abstract void delete(Teacher tea);
	 abstract Teacher update(Teacher tea);
}