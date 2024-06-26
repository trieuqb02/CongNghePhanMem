package shopsport.nhom18.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import shopsport.nhom18.model.Customer;

public interface CustomerService {
	int getQuantityOfCustomer(boolean b);
	List<Customer> getCustomersAccountStatus(boolean b, Pageable pageable);
	List<Customer> getCustomersByAccountStatusAndNameContaining(String name,boolean b,Pageable pageable);
	int getQuantityCustomersByAccountStatusAndNameContaining(String name,boolean b);
	Customer findOneByAccountUsername(String username);
}
