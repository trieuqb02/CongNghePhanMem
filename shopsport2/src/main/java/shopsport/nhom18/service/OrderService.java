package shopsport.nhom18.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import shopsport.nhom18.model.Order;

public interface OrderService {
	List<Order> getOrdersWithNoStaff(Pageable pageable);
	
	int getQuantityOrdersWithNoStaff();
	
	Order doOrderBrowsing(Long id,String idStaff);
	
	List<Order> getOrdersWithStaff(Pageable pageable);
	
	int getQuantityOrdersWithStaff();
	
	Order save(Order Order);

	List<Order> findAllByCustomer_Id(String id);

	Order findOneById(Long ido);
}
