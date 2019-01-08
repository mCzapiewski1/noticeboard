package pl.noticeboard.dao;

import java.util.List;

import pl.noticeboard.entity.Role;

public interface RoleDAO {
	
	public List<Role> getRoles();
	public Role getRole(int id);
	public void deleteRole(int id);
	public void saveRole(Role role);
}
