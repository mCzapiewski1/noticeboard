package pl.noticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.noticeboard.dao.RoleDAO;
import pl.noticeboard.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Transactional
	@Override
	public List<Role> getRoles() {
		
		return roleDAO.getRoles();
	}
	
	@Transactional
	@Override
	public Role getRole(int id) {
		
		return roleDAO.getRole(id);
	}
	
	@Transactional
	@Override
	public void deleteRole(int id) {
		
		roleDAO.deleteRole(id);
	}
	
	@Transactional
	@Override
	public void saveRole(Role role) {
		
		roleDAO.saveRole(role);
	}

}
