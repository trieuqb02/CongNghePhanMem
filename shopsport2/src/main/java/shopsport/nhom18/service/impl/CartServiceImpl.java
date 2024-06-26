package shopsport.nhom18.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.Cart;
import shopsport.nhom18.repository.CartRepository;
import shopsport.nhom18.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepository cartRepository;

	@Override
	public void delete(Long id) {
		cartRepository.delete(id);
		
	}

	@Override
	public Cart save(Cart cart) {
		return cartRepository.save(cart);
	}
	
	@Override
	public Cart getidCartbyidCustommer(String id) {
	    return cartRepository.findByCustomerId(id);
	}

	@Override
	public Cart getIdCart(Long id) {
		
		return cartRepository.findOne(id);
	}


}
