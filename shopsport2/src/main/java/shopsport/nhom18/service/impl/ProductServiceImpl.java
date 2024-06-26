package shopsport.nhom18.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.Category;
import shopsport.nhom18.model.Product;
import shopsport.nhom18.repository.CategoryRepository;
import shopsport.nhom18.repository.ProductRepository;
import shopsport.nhom18.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void save(Product product) {
		Category category = categoryRepository.findOne(product.getCategory().getId());
		
		product.setCategory(category);
		
		productRepository.save(product);
	}

	@Override
	public void delete(String id) {
		Product product = productRepository.findOne(id);
		product.setStatus(true);
		productRepository.save(product);
		
	}

	@Override
	public List<Product> getListProductAndStatus(boolean b,Pageable pageable) {
		return productRepository.findByStatus(b,pageable).getContent();
	}

	@Override
	public int getQuantityOfProductAndStatus(boolean b) {
		return  productRepository.findByStatus(b).size();
	}

	@Override
	public List<Product> getListProductByIdContainingAndStatus(String search,boolean b, Pageable pageable) {
		return productRepository.findByIdContainingAndStatus(search,b, pageable).getContent();
	}

	@Override
	public int getQuantityOfProductByIdContainingAndStatus(String search,boolean b) {
		return productRepository.findByIdContainingAndStatus(search,b).size();
	}

	@Override
	public Product getProductById(String id) {
		
		return productRepository.findOne(id);
	}

	@Override
	public Product update(Product product, String id) {
		Product updateProdcut = productRepository.findOne(id);
		
		updateProdcut.setName(product.getName());
		updateProdcut.setPrice(product.getPrice());
		updateProdcut.setDescription(product.getDescription());
		Category category = categoryRepository.findOne(product.getCategory().getId());
		updateProdcut.setCategory(category);
		
		if (product.getImage() != "") {
			updateProdcut.setImage(product.getImage());
		} 
		
		return productRepository.save(updateProdcut);
		
		
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductByIdCategory(String id) {
		
		return productRepository.findByCategoryId(id);
	}

}
