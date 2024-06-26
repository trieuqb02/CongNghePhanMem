package shopsport.nhom18.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import shopsport.nhom18.model.Supplier;

public interface SupplierService {
	void delete(String id);

	List<Supplier> getListSupplierByIdContainingAndStatus(String id,boolean b, Pageable pageable);
	
	int getQuantityOfSupplierByIdContainingAndStatus(String id,boolean b);
	
	List<Supplier> getListSupplierAndStatus(boolean b,Pageable pageable);
	
	int getQuantityOfSupplierAndStatus(boolean b);
	
	void save(Supplier supplier);
	
	Supplier getSupplier(String id);
	
	void update(Supplier supplier, String id);
	
	List<Supplier> getAll();

	void remove(String id);
}
