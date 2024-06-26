package shopsport.nhom18.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.Pay;
import shopsport.nhom18.repository.PayReponsitory;
import shopsport.nhom18.service.PayService;

@Service
public class PayServiceImpl implements PayService{
	
	@Autowired
	private PayReponsitory payReponsitory;
	
	@Override
	public Pay getPayById(String idPay) {
		
		return payReponsitory.findOne(idPay);
	}

}
