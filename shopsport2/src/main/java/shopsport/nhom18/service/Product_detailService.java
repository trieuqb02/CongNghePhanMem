package shopsport.nhom18.service;

import java.util.List;

import shopsport.nhom18.model.DetailsProduct;

public interface Product_detailService {
	DetailsProduct save(DetailsProduct detailsProduct);
	
	
	List<DetailsProduct> getAll();
	

	void deleteByProductIdAndCartId(String productId, Long cartId);
}
