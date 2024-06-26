package shopsport.nhom18.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import shopsport.nhom18.model.Product;

@Component
public class ProductUpdateValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty");
	}

}
