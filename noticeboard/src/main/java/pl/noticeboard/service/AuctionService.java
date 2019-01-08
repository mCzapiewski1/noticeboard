package pl.noticeboard.service;

import java.util.List;
import pl.noticeboard.entity.Auction;

public interface AuctionService {
	
	public List<Auction> getAuctions();
	public Auction getAuction(int id);
	public void deleteAuction(int id);
	public void saveAuction(Auction auction);
}
