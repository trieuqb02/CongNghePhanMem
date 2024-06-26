package shopsport.nhom18.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import shopsport.nhom18.model.Supplier;

@Component
public class SupplierUpdateVaditor implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Supplier.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Supplier supplier = (Supplier) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty");
		
		if (supplier.getPhone().length() != 0 ) {
			if(supplier.getPhone().length() < 10 || supplier.getPhone().length() > 10 ) {
	        	errors.rejectValue("phone", "Size.userForm.phone");
	        }
		}
		
	}

}
