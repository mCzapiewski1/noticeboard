package pl.noticeboard.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import pl.noticeboard.entity.Users;
import pl.noticeboard.user.NbUser;

public interface UsersService extends UserDetailsService{
	
	public List<Users> getUsers();
	public Users getUser(int id);
	public void deleteUser(int id);
	public void saveUser(Users user);
	public Users findUserByName(String userName);
	public void save(NbUser nbUser);
	public UserDetails loadUserByUsername(String username);
}
