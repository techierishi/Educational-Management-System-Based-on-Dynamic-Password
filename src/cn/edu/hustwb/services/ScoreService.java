package cn.edu.hustwb.services;

import java.util.List;

import cn.edu.hustwb.dto.Course;
import cn.edu.hustwb.dto.Score;

public interface ScoreService {

	void delete(Score persistentInstance);
	
	void add(Score transientInstance);
	
	Score findById(java.lang.Integer id);

	List<Score> findAll();

	Course merge(Score detachedInstance);
	
	 List<Score> findByExample(Score instance);
}
