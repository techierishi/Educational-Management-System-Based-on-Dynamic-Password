package cn.edu.hustwb.actions;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.hustwb.dto.News;
import cn.edu.hustwb.dto.User;
import cn.edu.hustwb.services.NewsService;
import cn.edu.hustwb.services.UserService;
import cn.edu.hustwb.vo.NewsVO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("news")
@Scope("prototype")
public class NewsAction extends ActionSupport implements ModelDriven,RequestAware,SessionAware,ApplicationAware{
	private NewsService ns;
	private UserService us;
	private NewsVO nvo =  new NewsVO();
	List<News> newslist;
	private int newsid;
	private News news;
	private Map<String, Object> session;
	/*
	 * 1.Action接收传过来的参数,有作者ID，创作时间,文章标题和文章内容
	 * 2.拿到User对象
	 * 3.new 一个 News对象，然后save
	 * */
	
	
	@Override
	public String execute() throws Exception{
		return "success";
	}
	
	public String write(){		//新建文章
		User user = (User) session.get("user");
		System.out.println("User的ID是"+user.getUserid());
		News news = new News(user, nvo.getNewstitle(), nvo.getNewscontent(), new Date());
		System.out.println("文章标题是"+news.getNewstitle());
		ns.add(news);
		return "writeSuccess";
	}

	public String list(){		//文章列表
		newslist = ns.findAll();
		return "list";
	}
	
	public String look(){		//文章具体内容
		news = ns.findById(this.newsid);
		return "look";
	}
	public String delete(){	//文章删除
		news = ns.findById(this.newsid);
		ns.delete(news);
		return "delete";
		
	}
	public NewsService getNs() {
		return ns;
	}
	@Resource
	public void setNs(NewsService ns) {
		this.ns = ns;
	}

	@Override
	public Object getModel() {
		return nvo;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public NewsVO getNvo() {
		return nvo;
	}

	public void setNvo(NewsVO nvo) {
		this.nvo = nvo;
	}

	public UserService getUs() {
		return us;
	}

	@Resource
	public void setUs(UserService us) {
		this.us = us;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		
	}

	public List<News> getNewslist() {
		return newslist;
	}

	public void setNewslist(List<News> newslist) {
		this.newslist = newslist;
	}

	public int getNewsid() {
		return newsid;
	}

	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
	
}
