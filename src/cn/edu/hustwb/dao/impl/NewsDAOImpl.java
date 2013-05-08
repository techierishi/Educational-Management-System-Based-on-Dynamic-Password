package cn.edu.hustwb.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.hustwb.dao.NewsDAO;
import cn.edu.hustwb.dto.News;

/**
 * A data access object (DAO) providing persistence and search support for News
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see cn.edu.hustwb.dto.News
 * @author MyEclipse Persistence Tools
 */
public class NewsDAOImpl extends HibernateDaoSupport implements NewsDAO {
	private static final Logger log = LoggerFactory.getLogger(NewsDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.NewsDAO#save(cn.edu.hustwb.dto.News)
	 */
	@Override
	public void save(News transientInstance) {
		log.debug("saving News instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.NewsDAO#delete(cn.edu.hustwb.dto.News)
	 */
	@Override
	public void delete(News persistentInstance) {
		log.debug("deleting News instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.NewsDAO#findById(java.lang.Integer)
	 */
	@Override
	public News findById(java.lang.Integer id) {
		log.debug("getting News instance with id: " + id);
		try {
			News instance = (News) getHibernateTemplate().get(
					"cn.edu.hustwb.dto.News", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.NewsDAO#findByExample(cn.edu.hustwb.dto.News)
	 */
	@Override
	public List<News> findByExample(News instance) {
		log.debug("finding News instance by example");
		try {
			List<News> results = (List<News>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.NewsDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding News instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from News as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.NewsDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all News instances");
		try {
			String queryString = "from News";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.NewsDAO#merge(cn.edu.hustwb.dto.News)
	 */
	@Override
	public News merge(News detachedInstance) {
		log.debug("merging News instance");
		try {
			News result = (News) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.NewsDAO#attachDirty(cn.edu.hustwb.dto.News)
	 */
	@Override
	public void attachDirty(News instance) {
		log.debug("attaching dirty News instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.NewsDAO#attachClean(cn.edu.hustwb.dto.News)
	 */
	@Override
	public void attachClean(News instance) {
		log.debug("attaching clean News instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewsDAO) ctx.getBean("NewsDAO");
	}
}