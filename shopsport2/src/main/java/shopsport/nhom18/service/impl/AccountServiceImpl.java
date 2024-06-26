package shopsport.nhom18.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.model.Cart;
import shopsport.nhom18.model.Role;
import shopsport.nhom18.repository.AccountRepository;
import shopsport.nhom18.repository.CartRepository;
import shopsport.nhom18.repository.RoleRepository;
import shopsport.nhom18.repository.StaffRepository;
import shopsport.nhom18.service.AccountService;
import shopsport.nhom18.utils.RandomStringGenerator;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private RoleRepository repository;

	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Account registerUser(Account user,String role) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

//		List<Role> roles = new ArrayList<Role>();

//		for (String role : strRoles) {
//			if (roleRepository.findOneByName(role) != null) {
//				roles.add(roleRepository.findOneByName(role));
//			} else {
//				Role r = new Role();
//				r.setId(RandomStringGenerator.generateRandomString(10));
//				r.setName(role);
//				repository.save(r);
//				roles.add(r);
//			}
//		}
		
		
		if (roleRepository.findOneByName(role) != null ) {
			user.setRole(roleRepository.findOneByName(role));
		} else {
			Role r = new Role();
			r.setId(RandomStringGenerator.generateRandomString(10));
			r.setName(role);
			repository.save(r);
			user.setRole(r);
		}

		String idCustomer = RandomStringGenerator.generateRandomString(10);
			
		user.getCustomer().setId(idCustomer);

		user.getCustomer().setAccount(user);

		accountRepository.save(user);
		
		Cart cart = new Cart();
		
		cart.setCustomer(user.getCustomer());
		
		cartRepository.save(cart);

		return user;
	}

	@Override
	public void deleteAccount(String id) {
		Account account = accountRepository.findOne(id);
		account.setStatus(true);
		accountRepository.save(account);
	}

	@Override
	public Account registerStaff(Account user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

//		List<Role> roles = new ArrayList<Role>();
//
//		for (Role role : user.getRoles()) {
//			roles.add(roleRepository.findOneByName(role.getName()));
//		}
//
//		user.setRoles(roles);
		
		Role role = roleRepository.findOneByName(user.getRole().getName());
		
		user.setRole(role);

		user.getStaff().setAccount(user);

		accountRepository.save(user);

		return user;

	}

	@Override
	public Account getAccountById(String id) {
		return accountRepository.findOne(id);
	}

	@Override
	public Account updateStaff(Account account,String id) {
		Account updateAccount = accountRepository.findOne(id);

//		List<Role> roles = new ArrayList<Role>();
//
//		for (Role role : account.getRoles()) {
//			roles.add(roleRepository.findOneByName(role.getName()));
//		}
		
		Role role = repository.findOneByName(account.getRole().getName());

		updateAccount.setRole(role);

		return accountRepository.save(updateAccount);
		
	}

	@Override
	public Account updateAccount(Account updateUser, String id) {
		Account account = accountRepository.findOne(id);
		
		account.getStaff().setPhone(updateUser.getStaff().getPhone());
		account.setEmail(updateUser.getEmail());
		account.getStaff().setCmnd(updateUser.getStaff().getCmnd());
		account.getStaff().setAddress(updateUser.getStaff().getAddress());
		if(updateUser.getStaff().getImage() != null) {
			account.getStaff().setImage(updateUser.getStaff().getImage());
		}
		
		return accountRepository.save(account);
	}

	@Override
	public void remove(String id) {
		accountRepository.delete(id);
		
	}

	

}
