package shopsport.nhom18.service;

import shopsport.nhom18.model.DetailsProduct;


public interface CartDetailsService {
	DetailsProduct getCartDetailsById(Long idCart,String idProduct);
	void updateCartDetails(DetailsProduct cardDetail);
}
