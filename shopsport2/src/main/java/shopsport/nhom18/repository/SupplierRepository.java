package shopsport.nhom18.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import shopsport.nhom18.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, String>{
	Page<Supplier> findByIdContainingAndStatus(String id,boolean b, Pageable pageable);
	List<Supplier> findByIdContainingAndStatus(String id,boolean b);
	Page<Supplier> findByStatus(boolean b, Pageable pageable);
	List<Supplier> findByStatus(boolean b);
	
	Supplier findOneByName(String name);
}
