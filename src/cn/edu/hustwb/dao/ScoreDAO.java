package cn.edu.hustwb.dao;

import java.util.List;

import cn.edu.hustwb.dto.Score;

public interface ScoreDAO {

	public abstract void save(Score transientInstance);

	public abstract void delete(Score persistentInstance);

	public abstract Score findById(cn.edu.hustwb.dto.ScoreId id);

	public abstract List<Score> findByExample(Score instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Score merge(Score detachedInstance);

	public abstract void attachDirty(Score instance);

	public abstract void attachClean(Score instance);

}