package shopsport.nhom18.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.Category;
import shopsport.nhom18.repository.CategoryRepository;
import shopsport.nhom18.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void delete(String id) {
		Category category = categoryRepository.findOne(id);
		category.setStatus(true);
		categoryRepository.save(category);
	}

	@Override
	public List<Category> getListCategoryAndStatus(boolean b,Pageable pageable) {
		return categoryRepository.findByStatus(b,pageable).getContent();
	}

	@Override
	public int getQuantityOfCategoryAndStatus(boolean b) {
		return (int) categoryRepository.findByStatus(b).size();
	}

	@Override
	public List<Category> getListCategoryByIdContainingAndStatus(String id,boolean b, Pageable pageable) {
		return categoryRepository.findByIdContainingAndStatus(id,b, pageable).getContent();
	}

	@Override
	public int getQuantityOfCategoryByIdContainingAndStatus(String id,boolean b) {
		return categoryRepository.findByIdContainingAndStatus(id,b).size();
	}

	@Override
	public Category getCategoryById(String id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public Category update(Category category,String id) {
		Category updateCategory = categoryRepository.findOne(id);
		
		updateCategory.setName(category.getName());

		return categoryRepository.save(updateCategory);
	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> getByStatus(boolean b) {
		return categoryRepository.findByStatus(b);
	}

}
