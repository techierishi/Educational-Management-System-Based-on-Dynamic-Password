package cn.edu.hustwb.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.hustwb.dao.ScoreDAO;
import cn.edu.hustwb.dto.Score;
import cn.edu.hustwb.dto.ScoreId;


public class ScoreDAOImpl extends HibernateDaoSupport implements ScoreDAO {
	private static final Logger log = LoggerFactory.getLogger(ScoreDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.ScoreDAO#save(cn.edu.hustwb.dto.Score)
	 */
	@Override
	public void save(Score transientInstance) {
		log.debug("saving Score instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.ScoreDAO#delete(cn.edu.hustwb.dto.Score)
	 */
	@Override
	public void delete(Score persistentInstance) {
		log.debug("deleting Score instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.ScoreDAO#findById(cn.edu.hustwb.dto.ScoreId)
	 */
	@Override
	public Score findById(cn.edu.hustwb.dto.ScoreId id) {
		log.debug("getting Score instance with id: " + id);
		try {
			Score instance = (Score) getHibernateTemplate().get(
					"cn.edu.hustwb.dto.Score", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.ScoreDAO#findByExample(cn.edu.hustwb.dto.Score)
	 */
	@Override
	public List<Score> findByExample(Score instance) {
		log.debug("finding Score instance by example");
		try {
			List<Score> results = (List<Score>) getHibernateTemplate()
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
	 * @see cn.edu.hustwb.dao.impl.ScoreDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Score instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Score as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.ScoreDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Score instances");
		try {
			String queryString = "from Score";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.ScoreDAO#merge(cn.edu.hustwb.dto.Score)
	 */
	@Override
	public Score merge(Score detachedInstance) {
		log.debug("merging Score instance");
		try {
			Score result = (Score) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.ScoreDAO#attachDirty(cn.edu.hustwb.dto.Score)
	 */
	@Override
	public void attachDirty(Score instance) {
		log.debug("attaching dirty Score instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.ScoreDAO#attachClean(cn.edu.hustwb.dto.Score)
	 */
	@Override
	public void attachClean(Score instance) {
		log.debug("attaching clean Score instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ScoreDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ScoreDAO) ctx.getBean("ScoreDAO");
	}
}