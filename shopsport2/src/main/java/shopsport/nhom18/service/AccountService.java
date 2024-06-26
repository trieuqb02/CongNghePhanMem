package shopsport.nhom18.service;

import shopsport.nhom18.model.Account;


public interface AccountService {
	Account registerUser(Account user, String role);
	Account registerStaff(Account user);
	void deleteAccount(String id);
	Account getAccountById(String id);
	Account updateStaff(Account account,String id);
	Account updateAccount(Account updateUser, String id);
	void remove(String id);
}
