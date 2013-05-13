package cn.edu.hustwb.services;

import java.util.List;

import cn.edu.hustwb.dto.News;;

public interface NewsService {
	void add(News transientInstance);
	List findAll();
	List<News>getNews();
	News findById(int id);
	void delete(News n);
}