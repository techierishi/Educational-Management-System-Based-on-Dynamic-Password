package cn.edu.hustwb.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.hustwb.dao.StudentDAO;
import cn.edu.hustwb.dto.Student;


public class StudentDAOImpl extends HibernateDaoSupport implements StudentDAO {
	private static final Logger log = LoggerFactory.getLogger(StudentDAOImpl.class);

	protected void initDao() {
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.StudentDAO#save(cn.edu.hustwb.dto.Student)
	 */
	@Override
	public void save(Student transientInstance) {
		log.debug("saving Student instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.StudentDAO#delete(cn.edu.hustwb.dto.Student)
	 */
	@Override
	public void delete(Student persistentInstance) {
		log.debug("deleting Student instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.StudentDAO#findById(java.lang.Integer)
	 */
	@Override
	public Student findById(java.lang.Integer id) {
		log.debug("getting Student instance with id: " + id);
		try {
			Student instance = (Student) getHibernateTemplate().get(
					"cn.edu.hustwb.dto.Student", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.StudentDAO#findByExample(cn.edu.hustwb.dto.Student)
	 */
	@Override
	public List<Student> findByExample(Student instance) {
		log.debug("finding Student instance by example");
		try {
			List<Student> results = (List<Student>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}


	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Student instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Student as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.StudentDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Student instances");
		try {
			String queryString = "from Student";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	@Override
	public Student merge(Student detachedInstance) {
		System.out.println(detachedInstance.getSex());
		log.debug("merging Student instance");
		try {
			Student result = (Student) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.StudentDAO#attachDirty(cn.edu.hustwb.dto.Student)
	 */
	@Override
	public void attachDirty(Student instance) {
		log.debug("attaching dirty Student instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.hustwb.dao.impl.StudentDAO#attachClean(cn.edu.hustwb.dto.Student)
	 */
	@Override
	public void attachClean(Student instance) {
		log.debug("attaching clean Student instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StudentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StudentDAO) ctx.getBean("StudentDAO");
	}
}