package shopsport.nhom18.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shopsport.nhom18.model.Account;

public interface AccountRepository extends JpaRepository<Account, String>{
	Account findOneByUsername(String username);
	Account findOneByEmail(String email);
}
