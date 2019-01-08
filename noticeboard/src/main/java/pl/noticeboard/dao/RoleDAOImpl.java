package pl.noticeboard.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.noticeboard.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Role> getRoles() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Role> query = currentSession.createQuery("from Role order by roleName", Role.class);
		List<Role> roles = query.getResultList();
		
		return roles;
	}

	@Override
	public Role getRole(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Role role = currentSession.get(Role.class, id);
		
		return role;
	}

	@Override
	public void deleteRole(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Role where id:=id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public void saveRole(Role role) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(role);
	}
	
	
}
