package shopsport.nhom18.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import shopsport.nhom18.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	Page<Cart> findByIdContaining(Long id, Pageable pageable);
    List<Cart> findByIdContaining(Long id);
    Cart findByCustomerId(String id);
    
    
}


