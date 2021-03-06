package com.bridgeit.todo.dao;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.todo.model.Note;
import com.bridgeit.todo.model.User;

@Service("UserDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/////////////// Register New Users ///////////////////////// */

	public int saveUser(User user) {
		int id = 0;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			id = (int) session.save(user);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return id;
	}

	////////////////// Login RegisteredUser ////////////

	@SuppressWarnings("deprecation")
	public User userLogin(User user) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", user.getEmail()));
		criteria.add(Restrictions.eq("password", user.getPassword()));
		criteria.add(Restrictions.eq("isActivated", true));
		User finalUser = (User) criteria.uniqueResult();
		if (finalUser == null) {
			session.close();
			return null;
		}
		session.close();
		return finalUser;
	}

	public User getUserByEmail(String email) {
		Session session = sessionFactory.openSession();

		try {
			Criteria criteria = session.createCriteria(User.class);
			Criterion email1 = Restrictions.eq("email", email);
			criteria.add(email1);
			User user = (User) criteria.uniqueResult();
			criteria.uniqueResult();
			session.close();
			return user;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	
	public User getUserById(int id) {
		Session session = sessionFactory.openSession();

		try {
			Criteria criteria = session.createCriteria(User.class);
			Criterion email1 = Restrictions.eq("id", id);
			criteria.add(email1);
			User user = (User) criteria.uniqueResult();
			criteria.uniqueResult();
			session.close();
			return user;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}

}