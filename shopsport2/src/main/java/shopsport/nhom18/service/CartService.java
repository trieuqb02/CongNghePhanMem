package shopsport.nhom18.service;

import shopsport.nhom18.model.Cart;

public interface CartService {
    void delete(Long id);
    Cart save(Cart cart);
    Cart getidCartbyidCustommer(String idcustomer);
    Cart getIdCart(Long id);
}