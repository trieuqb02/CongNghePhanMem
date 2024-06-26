package shopsport.nhom18.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import shopsport.nhom18.model.Product;
import shopsport.nhom18.repository.ProductRepository;

@Component
public class StringConverterProdcut implements Converter<String, Product>{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product convert(String source) {
		Product product = productRepository.findOne(source);
		return product;
	}

}
