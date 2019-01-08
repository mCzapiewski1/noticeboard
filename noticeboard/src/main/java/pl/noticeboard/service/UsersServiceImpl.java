package pl.noticeboard.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.noticeboard.dao.UsersDAO;
import pl.noticeboard.entity.Users;
import pl.noticeboard.user.NbUser;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired RoleService roleService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Transactional
	@Override
	public List<Users> getUsers() {
		
		return usersDAO.getUsers();
	}
	
	@Transactional
	@Override
	public Users getUser(int id) {
		
		return usersDAO.getUser(id);
	}
	
	@Transactional
	@Override
	public void deleteUser(int id) {
		
		usersDAO.deleteUser(id);
	}
	
	@Transactional
	@Override
	public void saveUser(Users user) {
		
		usersDAO.saveUser(user);
	}
	
	@Transactional
	@Override
	public Users findUserByName(String userName) {
		
		return usersDAO.findUserByName(userName);
	}
	
	@Transactional
	@Override
	public void save(NbUser nbUser) {
		
		Users user = new Users();
		user.setUsername(nbUser.getUserName());
		user.setPassword(passwordEncoder.encode(nbUser.getPassword()));
		user.setFirstName(nbUser.getFirstName());
		user.setLastName(nbUser.getLastName());
		user.setBirthDate(nbUser.getBirthDate());
		user.setEmail(nbUser.getEmail());
		user.setRoles(Arrays.asList(roleService.getRole(1)));
		usersDAO.saveUser(user);		
	}
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		Users user = usersDAO.findUserByName(username);
		if(user == null) {
			throw new UsernameNotFoundException("Niepoprawny login badz haslo");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<pl.noticeboard.entity.Role> roles){
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}
	

}
