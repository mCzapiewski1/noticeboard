package pl.noticeboard.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.noticeboard.entity.Auction;

@Repository
public class AuctionDAOImpl implements AuctionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Auction> getAuctions() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Auction> query = currentSession.createQuery("from Auction order by creationDate", Auction.class);
		List<Auction> auctions = query.getResultList();
		
		return auctions;
	}

	@Override
	public Auction getAuction(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Auction auction = currentSession.get(Auction.class, id);
		
		return auction;
	}

	@Override
	public void deleteAuction(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Auction where id:=id");
		query.setParameter("id",id);
		query.executeUpdate();
	}

	@Override
	public void saveAuction(Auction auction) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(auction);
	}

}
