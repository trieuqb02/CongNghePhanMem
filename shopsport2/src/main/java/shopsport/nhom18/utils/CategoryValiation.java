package shopsport.nhom18.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import shopsport.nhom18.model.Category;
import shopsport.nhom18.repository.CategoryRepository;

@Component
public class CategoryValiation implements Validator {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Category.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Category category = (Category) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");

		if (categoryRepository.findOneByName(category.getName()) != null) {
			errors.rejectValue("name", "Exist.category.name");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "NotEmpty");

		if (categoryRepository.findOne(category.getId()) != null) {
			errors.rejectValue("id", "Exist.category.id");
		}
	}

}
