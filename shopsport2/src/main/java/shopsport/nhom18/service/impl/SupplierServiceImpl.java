package shopsport.nhom18.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.Supplier;
import shopsport.nhom18.repository.SupplierRepository;
import shopsport.nhom18.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public void delete(String id) {
		Supplier supplier = supplierRepository.findOne(id);
		supplier.setStatus(true);
		supplierRepository.save(supplier);
	}

	@Override
	public List<Supplier> getListSupplierByIdContainingAndStatus(String id, boolean b, Pageable pageable) {
		return supplierRepository.findByIdContainingAndStatus(id, b, pageable).getContent();
	}

	@Override
	public int getQuantityOfSupplierByIdContainingAndStatus(String id, boolean b) {
		return supplierRepository.findByIdContainingAndStatus(id, b).size();
	}

	@Override
	public List<Supplier> getListSupplierAndStatus(boolean b, Pageable pageable) {
		return supplierRepository.findByStatus(b, pageable).getContent();
	}

	@Override
	public int getQuantityOfSupplierAndStatus(boolean b) {
		return supplierRepository.findByStatus(b).size();
	}

	@Override
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);

	}

	@Override
	public Supplier getSupplier(String id) {

		return supplierRepository.findOne(id);
	}

	@Override
	public void update(Supplier supplier, String id) {
		Supplier updateSupplier = supplierRepository.findOne(id);

		updateSupplier.setName(supplier.getName());
		updateSupplier.setPhone(supplier.getPhone());
		updateSupplier.setAddress(supplier.getAddress());

		supplierRepository.save(updateSupplier);
	}

	@Override
	public List<Supplier> getAll() {
		return supplierRepository.findAll();
	}

	@Override
	public void remove(String id) {
		supplierRepository.delete(id);
	}
}
