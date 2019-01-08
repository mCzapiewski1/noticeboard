package pl.noticeboard.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.noticeboard.entity.Opinions;

@Repository
public class OpinionsDAOImpl implements OpinionsDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Opinions> getOpinions() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Opinions> query = currentSession.createQuery("from Opinions order by id", Opinions.class);
		List<Opinions> opinions = query.getResultList();
		
		return opinions;
	}

	@Override
	public Opinions getOpinion(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Opinions opinion = currentSession.get(Opinions.class,id);
		
		return opinion;
	}

	@Override
	public void deleteOpinion(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Opinions where id:=id");
		query.setParameter("id",id);
		query.executeUpdate();
	}

	@Override
	public void saveopinion(Opinions opinion) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(opinion);
	}

}
