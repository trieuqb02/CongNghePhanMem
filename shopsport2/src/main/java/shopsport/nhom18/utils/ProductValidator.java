package shopsport.nhom18.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import shopsport.nhom18.model.Product;
import shopsport.nhom18.repository.ProductRepository;

@Component
public class ProductValidator implements Validator{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "NotEmpty");
		
		if ( productRepository.findOne(product.getId()) != null) {
			errors.rejectValue("id", "Exist.category.id");
		}
		
		if ( productRepository.findOneByName(product.getName()) != null) {
			errors.rejectValue("name", "Exist.category.name");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty");
		
		

	}

}
