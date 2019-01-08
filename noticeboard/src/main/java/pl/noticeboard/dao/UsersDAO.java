package pl.noticeboard.dao;

import java.util.List;

import pl.noticeboard.entity.Users;

public interface UsersDAO {
	
	public List<Users> getUsers();
	public Users getUser(int id);
	public void deleteUser(int id);
	public void saveUser(Users user);
	public Users findUserByName(String userName);	
}
