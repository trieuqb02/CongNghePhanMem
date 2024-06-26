package shopsport.nhom18.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.Customer;
import shopsport.nhom18.repository.CustomerRepository;
import shopsport.nhom18.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public int getQuantityOfCustomer(boolean b) {
		return (int) customerRepository.findByAccountStatus(b).size();
	}

	@Override
	public List<Customer> getCustomersAccountStatus(boolean b, Pageable pageable) {
		return customerRepository.findByAccountStatus(b, pageable).getContent();
	}


	@Override
	public int getQuantityCustomersByAccountStatusAndNameContaining(String name,boolean b) {
		return customerRepository.findByAccountStatusAndNameContaining(b, name).size();
	}

	@Override
	public List<Customer> getCustomersByAccountStatusAndNameContaining(String name, boolean b, Pageable pageable) {
		return customerRepository.findByAccountStatusAndNameContaining( b,name, pageable).getContent();
	}

	@Override
	public Customer findOneByAccountUsername(String username) {
		return customerRepository.findOneByAccountUsername(username);
	}

	

}
