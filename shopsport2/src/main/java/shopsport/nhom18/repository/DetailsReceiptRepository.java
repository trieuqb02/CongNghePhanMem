package shopsport.nhom18.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shopsport.nhom18.model.DetailsReceipt;
import shopsport.nhom18.model.DetailsReceiptPK;

public interface DetailsReceiptRepository extends JpaRepository<DetailsReceipt, DetailsReceiptPK>{
	
}
