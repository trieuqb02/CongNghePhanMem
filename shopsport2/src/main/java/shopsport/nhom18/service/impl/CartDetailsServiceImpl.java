package shopsport.nhom18.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.DetailsProduct;
import shopsport.nhom18.model.DetailsProductPk;
import shopsport.nhom18.repository.CartDetailsRepository;
import shopsport.nhom18.service.CartDetailsService;

@Service
public class CartDetailsServiceImpl implements CartDetailsService{
	
	@Autowired
	private CartDetailsRepository cartDetailsRepository;
	
	@Override
	public DetailsProduct getCartDetailsById(Long idCart, String idProduct) {
		DetailsProductPk pk = new DetailsProductPk(idCart, idProduct);
		
		return cartDetailsRepository.findOne(pk);
	}

	@Override
	public void updateCartDetails(DetailsProduct cardDetail) {
		cartDetailsRepository.save(cardDetail);
		
	}

}
