package pl.noticeboard.dao;

import java.util.List;

import pl.noticeboard.entity.Auction;

public interface AuctionDAO {
	
	public List<Auction> getAuctions();
	public Auction getAuction(int id);
	public void deleteAuction(int id);
	public void saveAuction(Auction auction);
	
}
