package shopsport.nhom18.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.model.Customer;
import shopsport.nhom18.repository.AccountRepository;
import shopsport.nhom18.repository.CustomerRepository;
import shopsport.nhom18.repository.StaffRepository;

@Component
public class UpdateValidator implements Validator{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Account.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Account user = (Account) target;
		
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "staff.phone", "NotEmpty");
		
		if (user.getStaff().getPhone().length() != 0 ) {
			if(user.getStaff().getPhone().length() < 10 || user.getStaff().getPhone().length() > 10 ) {
	        	errors.rejectValue("staff.phone", "Size.userForm.phone");
	        }
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "staff.address", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "staff.cmnd", "NotEmpty");
		
		
		
	}

}
