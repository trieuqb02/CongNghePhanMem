package shopsport.nhom18.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import shopsport.nhom18.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	
	
	List<Customer> findByAccountStatus(boolean b);
	
	Page<Customer> findByAccountStatus(boolean b,Pageable pageable);
	
	Page<Customer> findByAccountStatusAndNameContaining(boolean b,String name,Pageable pageable);
	
	List<Customer> findByAccountStatusAndNameContaining(boolean b,String name);
	
	Customer findOneByAccountUsername(String username);
}
