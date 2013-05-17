package cn.edu.hustwb.util;

import java.util.Comparator;
import java.util.Date;

import cn.edu.hustwb.dto.News;

public class NewsSort implements Comparator<News>{

	public int compare(News o1, News o2) {
		System.out.println(o2.getNewsid()-o1.getNewsid());
		return o2.getNewsid()-o1.getNewsid();
	}


}
