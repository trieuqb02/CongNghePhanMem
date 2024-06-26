package shopsport.nhom18.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.repository.AccountRepository;
import shopsport.nhom18.repository.StaffRepository;

@Component
public class UpdateStaffValidator implements Validator {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Account.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Account user = (Account) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "NotEmpty");


	}

}
