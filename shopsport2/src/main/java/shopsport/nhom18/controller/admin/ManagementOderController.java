package shopsport.nhom18.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.model.DetailsOder;
import shopsport.nhom18.model.Order;
import shopsport.nhom18.model.Paging;
import shopsport.nhom18.service.AccountService;
import shopsport.nhom18.service.OrderService;
import shopsport.nhom18.utils.SecurityUtils;

@Controller
@RequestMapping("/admin/management/order/")
public class ManagementOderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AccountService accountService;

	@GetMapping(path = {"list", "orderBrowsing"})
	public ModelAndView showPageOder(@RequestParam(name = "id", required = false) Long id,
			@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "1") int limit) {
		ModelAndView mav = new ModelAndView("admin/order/list-order");
		
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		Paging paging = new Paging();
		paging.setPage(page);
		paging.setMaxPageItem(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		
		if (id != null) {
			orderService.doOrderBrowsing(id, inforUser.getStaff().getId());
		}
		
		List<Double> sumPrice = new ArrayList<Double>();
		
		List<Order> orders = orderService.getOrdersWithNoStaff(pageable);
		
		for (Order order : orders) {
			Double sum = 0d;
			for (DetailsOder dO : order.getDetailsOders()) {
				sum += dO.getQuantity() * dO.getPrice();
			}
			sumPrice.add(sum);
		}
		
		mav.addObject("sumPrice", sumPrice);
		
		mav.addObject("listOrder", orderService.getOrdersWithNoStaff(pageable));

		paging.setTotalItem(orderService.getQuantityOrdersWithNoStaff());
		paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
		mav.addObject("paging", paging);
		
		return mav;
	}
	
	@GetMapping("list/approved")
	public ModelAndView showPageOrderApproved(
			@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "1") int limit) {
		ModelAndView  mav = new ModelAndView("admin/order/list-order-approved");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		Paging paging = new Paging();
		paging.setPage(page);
		paging.setMaxPageItem(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		
		List<Double> sumPrice = new ArrayList<Double>();
		
		List<Order> orders = orderService.getOrdersWithStaff(pageable);
		
		List<Date> dates = new ArrayList<Date>();
		
		for (Order order : orders) {
			Double sum = 0d;
			
			for (DetailsOder dO : order.getDetailsOders()) {
				sum += dO.getQuantity() * dO.getPrice();
			}
			sumPrice.add(sum);
			
		}
		
		mav.addObject("listDates", dates);
		
		mav.addObject("sumPrice", sumPrice);
		
		mav.addObject("listOrder", orderService.getOrdersWithStaff(pageable));

		paging.setTotalItem(orderService.getQuantityOrdersWithStaff());
		paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
		mav.addObject("paging", paging);
		
		return mav;
	}
}
