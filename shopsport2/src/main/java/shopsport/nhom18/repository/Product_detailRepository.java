package shopsport.nhom18.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import shopsport.nhom18.model.DetailsProduct;
import shopsport.nhom18.model.DetailsProductPk;

public interface Product_detailRepository extends JpaRepository<DetailsProduct, DetailsProductPk> {
	 void deleteByProductIdAndCartId(String product, Long cart);
	 
	 List<DetailsProduct> findByCartId(Long id);
}