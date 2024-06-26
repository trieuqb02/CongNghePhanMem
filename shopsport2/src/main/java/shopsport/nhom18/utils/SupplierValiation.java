package shopsport.nhom18.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import shopsport.nhom18.model.Category;
import shopsport.nhom18.model.Supplier;
import shopsport.nhom18.repository.CategoryRepository;
import shopsport.nhom18.repository.SupplierRepository;

@Component
public class SupplierValiation implements Validator{
	
	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Supplier.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Supplier supplier = (Supplier) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "NotEmpty");
		
		if (supplierRepository.findOne(supplier.getId()) != null) {
			errors.rejectValue("id", "Exist.category.id");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		
		if (supplierRepository.findOneByName(supplier.getName()) != null) {
			errors.rejectValue("name", "Exist.category.name");
		}
		
		if(supplier.getPhone().length() != 10 && supplier.getPhone().length() > 0) {
			errors.rejectValue("phone", "Size.userForm.phone");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty");
		
	}

}
