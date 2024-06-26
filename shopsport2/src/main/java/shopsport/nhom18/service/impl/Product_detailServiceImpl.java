package shopsport.nhom18.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.DetailsProduct;
import shopsport.nhom18.repository.Product_detailRepository;
import shopsport.nhom18.service.Product_detailService;

@Service
public class Product_detailServiceImpl implements Product_detailService{
	
	@Autowired
	Product_detailRepository product_detail;
	
	@Override
	public DetailsProduct save(DetailsProduct detailsProduct) {
		// TODO Auto-generated method stub
		return product_detail.save(detailsProduct);
	}


	@Override
	public List<DetailsProduct> getAll() {
		
		return product_detail.findAll();
	}

	@Override
	@Transactional
	public void deleteByProductIdAndCartId(String productId, Long cartId) {
	    product_detail.deleteByProductIdAndCartId(productId, cartId);;
	}

}
