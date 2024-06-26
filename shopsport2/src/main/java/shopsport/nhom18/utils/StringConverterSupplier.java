package shopsport.nhom18.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import shopsport.nhom18.model.Supplier;
import shopsport.nhom18.repository.SupplierRepository;

@Component
public class StringConverterSupplier implements Converter<String, Supplier>{
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public Supplier convert(String source) {
		Supplier supplier = supplierRepository.findOne(source);
		return supplier;
	}

}
