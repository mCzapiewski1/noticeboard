package pl.noticeboard.service;

import java.util.List;
import pl.noticeboard.entity.Role;

public interface RoleService {
	
	public List<Role> getRoles();
	public Role getRole(int id);
	public void deleteRole(int id);
	public void saveRole(Role role);
}
