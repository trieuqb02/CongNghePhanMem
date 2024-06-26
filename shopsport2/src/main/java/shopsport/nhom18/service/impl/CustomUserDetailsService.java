package shopsport.nhom18.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.model.MyUser;
import shopsport.nhom18.model.Role;
import shopsport.nhom18.repository.AccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Account user = accountRepository.findOneByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not exist!");
		}
		if (user.isStatus()) {
			throw new DisabledException("Account is locked!");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
//		for (Role role : user.getRoles()) {
//			authorities.add(new SimpleGrantedAuthority(role.getName()));
//		}
		
		authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
		
		if ( user.getStaff() != null) {
			MyUser myUser = new MyUser(user.getStaff().getImage(),user.getUsername(), user.getPassword(), true, true, true, true, authorities);
			myUser.setFullName(user.getUsername());
			return myUser;
		} else {
			MyUser myUser = new MyUser(user.getCustomer().getImage(),user.getUsername(), user.getPassword(), true, true, true, true, authorities);
			myUser.setFullName(user.getUsername());
			return myUser;
		}
		
		
	}

}
