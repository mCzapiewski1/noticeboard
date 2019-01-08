package pl.noticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.noticeboard.dao.OpinionsDAO;
import pl.noticeboard.entity.Opinions;

@Service
public class OpinionsServiceImpl implements OpinionsService {

	@Autowired
	private OpinionsDAO opinionsDAO;
	
	@Transactional
	@Override
	public List<Opinions> getOpinions() {
		
		return opinionsDAO.getOpinions();
	}
	
	@Transactional
	@Override
	public Opinions getOpinion(int id) {
		
		return opinionsDAO.getOpinion(id);
	}
	
	@Transactional
	@Override
	public void deleteOpinion(int id) {
		
		opinionsDAO.deleteOpinion(id);
	}
	
	@Transactional
	@Override
	public void saveopinion(Opinions opinion) {
		
		opinionsDAO.saveopinion(opinion);
	}

}
