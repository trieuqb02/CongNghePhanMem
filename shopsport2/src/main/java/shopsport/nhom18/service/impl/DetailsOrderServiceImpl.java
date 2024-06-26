package shopsport.nhom18.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.DetailsOder;
import shopsport.nhom18.repository.DetailsOrderRepository;
import shopsport.nhom18.service.DetailsOrderService;

@Service
public class DetailsOrderServiceImpl implements DetailsOrderService{
	@Autowired
	private DetailsOrderRepository detailsOrderRepository;
	
	@Override
	public void save(DetailsOder detailsOder) {
		detailsOrderRepository.save(detailsOder);
		
	}

}
