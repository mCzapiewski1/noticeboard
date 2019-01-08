package pl.noticeboard.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.noticeboard.entity.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Users> getUsers() {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<Users> query = currentSession.createQuery("from Users order by username", Users.class);
		List<Users> users = query.getResultList();
		return users;
	}

	@Override
	public Users getUser(int id) {

		Session currentSession = sessionFactory.getCurrentSession();
		Users user = currentSession.get(Users.class, id);
		return user;
	}

	@Override
	public void deleteUser(int id) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Users where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public void saveUser(Users user) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(user);
	}

	@Override
	public Users findUserByName(String userName) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<Users> query = currentSession.createQuery("from Users where username=:username", Users.class);
		query.setParameter("username", userName);
		Users user = query.getSingleResult();
		return user;
	}

}
