package shopsport.nhom18.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import shopsport.nhom18.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{
	Category findOneByName(String name);
	Page<Category> findByIdContainingAndStatus(String id, boolean b, Pageable pageable);
	List<Category> findByIdContainingAndStatus(String id, boolean b);
	Page<Category> findByStatus(boolean b, Pageable pageable);
	List<Category> findByStatus(boolean b);
	
	
}	
