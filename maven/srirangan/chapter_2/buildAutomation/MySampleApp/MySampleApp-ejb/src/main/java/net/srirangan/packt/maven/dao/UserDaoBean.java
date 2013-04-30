package net.srirangan.packt.maven.dao;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.srirangan.packt.maven.User;
import net.srirangan.packt.maven.User_;
import net.srirangan.packt.maven.dao.common.AbstractDaoBean;

@Stateless
public class UserDaoBean extends AbstractDaoBean<User> implements UserDao {

	@Inject
	private Logger log;

	@Override
	public User findByUsername(final String username) {

		log.info("find user with username " + username);

		CriteriaBuilder builder = getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);

		Root<User> user = query.from(User.class);

		query.where(builder.equal(user.get(User_.username), username));

		return getSingleResult(query);
	}
}
