package cn.edu.hustwb.services;

import java.util.List;

import cn.edu.hustwb.dto.Course;
import cn.edu.hustwb.dto.Score;
import cn.edu.hustwb.dto.ScoreId;

public interface ScoreService {

	void delete(Score persistentInstance);
	
	void add(Score transientInstance);
	
	Score findById(ScoreId sid);

	List<Score> findAll();

	Score merge(Score detachedInstance);
	
	 List<Score> findByExample(Score instance);
}
