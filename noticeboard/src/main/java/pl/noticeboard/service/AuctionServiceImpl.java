package pl.noticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.noticeboard.dao.AuctionDAO;
import pl.noticeboard.entity.Auction;

@Service
public class AuctionServiceImpl implements AuctionService{
	
	@Autowired
	private AuctionDAO auctionDAO;
	
	@Transactional
	@Override
	public List<Auction> getAuctions() {
		
		return auctionDAO.getAuctions();
	}
	
	@Transactional
	@Override
	public Auction getAuction(int id) {
		
		return auctionDAO.getAuction(id);
	}
	
	@Transactional
	@Override
	public void deleteAuction(int id) {
		
		auctionDAO.deleteAuction(id);
	}
	
	@Transactional
	@Override
	public void saveAuction(Auction auction) {
		
		auctionDAO.saveAuction(auction);
	}

}
