package pl.noticeboard.service;

import java.util.List;
import pl.noticeboard.entity.Opinions;

public interface OpinionsService {
	
	public List<Opinions> getOpinions();
	public Opinions getOpinion(int id);
	public void deleteOpinion(int id);
	public void saveopinion(Opinions opinion);
}
