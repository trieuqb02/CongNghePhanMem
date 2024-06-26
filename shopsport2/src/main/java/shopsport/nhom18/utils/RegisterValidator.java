package shopsport.nhom18.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.repository.AccountRepository;
import shopsport.nhom18.repository.CustomerRepository;

@Component
public class RegisterValidator implements Validator {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Account.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Account user = (Account) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        
        if (accountRepository.findOneByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Exist.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        
        if (user.getPassword().length() < 6 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if(accountRepository.findOneByEmail(user.getEmail()) != null) {
        	errors.rejectValue("email", "Exist.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer.phone", "NotEmpty");
        if(user.getCustomer().getPhone().length() < 10 || user.getCustomer().getPhone().length() > 10) {
        	errors.rejectValue("customer.phone", "Size.userForm.phone");
        }

	}

}
