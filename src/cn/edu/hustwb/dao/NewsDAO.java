package cn.edu.hustwb.dao;

import java.util.List;

import cn.edu.hustwb.dto.News;

public interface NewsDAO {

	public abstract void save(News transientInstance);

	public abstract void delete(News persistentInstance);

	public abstract News findById(java.lang.Integer id);

	public abstract List<News> findByExample(News instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract News merge(News detachedInstance);

	public abstract void attachDirty(News instance);

	public abstract void attachClean(News instance);

}