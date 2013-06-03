package cn.edu.hustwb.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hustwb.dao.ScoreDAO;
import cn.edu.hustwb.dto.Course;
import cn.edu.hustwb.dto.Score;
import cn.edu.hustwb.dto.ScoreId;
import cn.edu.hustwb.services.ScoreService;
@Service("scoreService")
@Transactional(propagation = Propagation.REQUIRED)
public class ScoreServiceImpl implements ScoreService {
	private ScoreDAO scoreDao;
	@Override
	public void delete(Score s) {
		scoreDao.delete(s);
	}

	@Override
	public void add(Score s) {
		scoreDao.save(s);
	}

	@Override
	public List<Score> findAll() {
		return scoreDao.findAll();
	}

	@Override
	public Score merge(Score s) {
		return scoreDao.merge(s);
	}

	@Override
	public List<Score> findByExample(Score instance) {
		return scoreDao.findByExample(instance);
	}
	
	public ScoreDAO getScoreDao() {
		return scoreDao;
	}
	@Resource
	public void setScoreDao(ScoreDAO scoreDao) {
		this.scoreDao = scoreDao;
	}

	@Override
	public Score findById(ScoreId sid) {
		return scoreDao.findById(sid);
	}

}
