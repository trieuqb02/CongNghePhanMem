package shopsport.nhom18.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import shopsport.nhom18.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	Page<Product> findByIdContainingAndStatus(String id, boolean b, Pageable pageable);

	List<Product> findByIdContainingAndStatus(String id, boolean b);

	Page<Product> findByStatus(boolean b, Pageable pageable);

	List<Product> findByStatus(boolean b);
	
	Product findOneByName(String name);
	
	List<Product> findByCategoryId(String id);
}
