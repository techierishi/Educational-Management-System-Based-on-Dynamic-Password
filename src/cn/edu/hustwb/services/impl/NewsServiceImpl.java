package cn.edu.hustwb.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hustwb.dao.NewsDAO;
import cn.edu.hustwb.dto.News;
import cn.edu.hustwb.services.NewsService;


@Service("newsService")
@Transactional(propagation = Propagation.REQUIRED)
public class NewsServiceImpl implements NewsService {
	private NewsDAO newsDao;

	@Override
	public void add(News transientInstance) {
		newsDao.save(transientInstance);
	}

	@Override
	public List findAll() {
		return newsDao.findAll();
	}

	@Override
	public List<News> getNews() {
		return null;
	}

	public void delete(News n){
		newsDao.delete(n);
	}
	public NewsDAO getNewsDao() {
		return newsDao;
	}
	
	@Resource
	public void setNewsDao(NewsDAO newsDao) {
		this.newsDao = newsDao;
	}

	@Override
	public News findById(int id) {
		return newsDao.findById(id);
	}



}
