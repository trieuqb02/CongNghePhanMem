package shopsport.nhom18.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shopsport.nhom18.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, String>{
	List<Receipt> findByIdContaining(String id);
	
	Page<Receipt> findByIdContaining(String id,Pageable pageable);
	
	@Query("SELECT r, r.date as date FROM Receipt r WHERE r.date BETWEEN :startDate AND :endDate GROUP BY r.date")
    List<Object[]> countByImportDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
