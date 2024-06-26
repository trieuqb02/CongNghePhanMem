package shopsport.nhom18.utils;

import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.repository.AccountRepository;
import shopsport.nhom18.repository.StaffRepository;

@Component
public class RegisterStaffValidatior implements Validator{
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
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		
		if( user.getUsername().length() != 0) {
			 if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
		            errors.rejectValue("username", "Size.userForm.username");
		        }
		}
		
       
        if (accountRepository.findOneByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Exist.userForm.username");
        }
        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        
        if(user.getPassword().length() != 0) {
        	if (user.getPassword().length() < 6 || user.getPassword().length() > 32) {
        		errors.rejectValue("password", "Size.userForm.password");
        	}
        }
        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "staff.surname", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "staff.name", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "staff.cmnd", "NotEmpty");
        
        if(user.getStaff().getCmnd().length() != 0) {
        	if ( user.getStaff().getCmnd().length() > 12 || user.getStaff().getCmnd().length() < 12) {
        		errors.rejectValue("staff.cmnd", "Size.userForm.cmnd");
        	}
        }
        
        if ( accountRepository.findOneByEmail(user.getEmail()) != null) {
        	errors.rejectValue("email", "Exist.userForm.email");
        }
        
        if ( staffRepository.findOneByCmnd(user.getStaff().getCmnd()) != null) {
        	errors.rejectValue("staff.cmnd", "Exist.userForm.cmnd");
        }
        
        ValidationUtils.rejectIfEmpty(errors, "staff.gender", "NotEmpty");
       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "staff.address", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "staff.phone", "NotEmpty");
        
        ValidationUtils.rejectIfEmpty(errors, "staff.dateOfBirth", "NotEmpty");
        
        if(user.getStaff().getPhone().length() != 0) {
        	if(user.getStaff().getPhone().length() < 10 || user.getStaff().getPhone().length() > 10) {
        		errors.rejectValue("staff.phone", "Size.userForm.phone");
        	}
        }
		
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "staff.id", "NotEmpty");
        if(staffRepository.findOne(user.getStaff().getId()) != null) {
        	errors.rejectValue("staff.id", "Exist.category.id");
        }
        
        if (user.getStaff().getDateOfBirth() != null) {
        	Calendar calendar = Calendar.getInstance();
            calendar.setTime(user.getStaff().getDateOfBirth());
            
            int year = calendar.get(Calendar.YEAR);
            int month =calendar.get(Calendar.MONTH) + 1;
            int day =calendar.get(Calendar.DAY_OF_MONTH);
            
            
            LocalDate birthDate = LocalDate.of(year, month, day);  

            LocalDate currentDate = LocalDate.now();
            LocalDate minimumAgeDate = birthDate.plusYears(18);

            if (currentDate.isEqual(minimumAgeDate) || currentDate.isAfter(minimumAgeDate)) {
            	
            } else {
            	errors.rejectValue("staff.dateOfBirth", "birth");
            }
        }
        
        

	}

}
