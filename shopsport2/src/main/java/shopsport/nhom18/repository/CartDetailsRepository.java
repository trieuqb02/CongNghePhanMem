package shopsport.nhom18.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shopsport.nhom18.model.DetailsProduct;
import shopsport.nhom18.model.DetailsProductPk;

public interface CartDetailsRepository extends JpaRepository<DetailsProduct,DetailsProductPk>{

}
