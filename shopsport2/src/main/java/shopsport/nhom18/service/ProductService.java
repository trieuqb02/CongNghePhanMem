package shopsport.nhom18.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import shopsport.nhom18.model.Product;

public interface ProductService {

	void save(Product product);
	
	void delete(String id);
	
	List<Product> getListProductAndStatus(boolean b,Pageable pageable);
	
	int getQuantityOfProductAndStatus(boolean b);
	
	List<Product> getListProductByIdContainingAndStatus(String search,boolean b,Pageable pageable);
	
	int getQuantityOfProductByIdContainingAndStatus(String search,boolean b);
	
	Product getProductById(String id);

	Product update(Product product, String id);
	
	List<Product> getAll();
	
	List<Product> getProductByIdCategory(String id);
}
