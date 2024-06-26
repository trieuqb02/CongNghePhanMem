package shopsport.nhom18.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.Order;
import shopsport.nhom18.model.Staff;
import shopsport.nhom18.repository.OrderRepository;
import shopsport.nhom18.repository.StaffRepository;
import shopsport.nhom18.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private StaffRepository staffRepository;
	

	@Override
	public List<Order> getOrdersWithNoStaff(Pageable pageable) {
		return orderRepository.findOrdersWithNoStaff(pageable).getContent();
	}

	@Override
	public int getQuantityOrdersWithNoStaff() {
		return orderRepository.findOrdersWithNoStaff().size();
	}

	@Override
	public Order doOrderBrowsing(Long id, String idStaff) {
		Order order = orderRepository.findOne(id);
		Staff staff = staffRepository.findOne(idStaff);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		order.setUpdateDate(date);
		order.setStatus("Đã duyệt");
		
		order.setStaff(staff);
		
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getOrdersWithStaff(Pageable pageable) {
		return orderRepository.findOrdersWithStaff(pageable).getContent();
	}

	@Override
	public int getQuantityOrdersWithStaff() {
		return orderRepository.findOrdersWithStaff().size();
	}

	@Override
	public Order save(Order Order) {
		return orderRepository.save(Order);
		
	}

	@Override
	public List<Order> findAllByCustomer_Id(String id) {
		return orderRepository.findAllByCustomer_Id(id);
	}

	@Override
	public Order findOneById(Long id) {
		return orderRepository.findOneById(id);
	}

	
}
