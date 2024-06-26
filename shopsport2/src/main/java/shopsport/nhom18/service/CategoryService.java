package shopsport.nhom18.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import shopsport.nhom18.model.Category;

public interface CategoryService {
	Category save(Category category);
	
	void delete(String id);
	
	List<Category> getListCategoryAndStatus(boolean b,Pageable pageable);
	
	int getQuantityOfCategoryAndStatus(boolean b);
	
	List<Category> getListCategoryByIdContainingAndStatus(String id,boolean b,Pageable pageable);
	
	int getQuantityOfCategoryByIdContainingAndStatus(String id,boolean b);
	
	Category getCategoryById(String id);
	
	Category update(Category category,String id);
	
	List<Category> getAll();
	
	List<Category> getByStatus(boolean b);
}
