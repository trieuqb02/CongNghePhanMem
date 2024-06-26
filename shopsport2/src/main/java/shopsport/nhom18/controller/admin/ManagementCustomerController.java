package shopsport.nhom18.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.model.Paging;
import shopsport.nhom18.service.AccountService;
import shopsport.nhom18.service.CustomerService;
import shopsport.nhom18.utils.SecurityUtils;

@Controller
@RequestMapping("/admin/management/customer/")
public class ManagementCustomerController {
	@Autowired
	private AccountService accountService;

	@Autowired
	private CustomerService customerService;
	

	@GetMapping("list")
	public ModelAndView showListStaff(@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "1") int limit) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/customer/list-customer");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);
		Paging paging = new Paging();
		paging.setPage(page);
		paging.setMaxPageItem(limit);
		Pageable pageable = new PageRequest(page - 1, limit);

		if (id != null) {
			accountService.deleteAccount(id);
		}

		if (search != "") {
			mav.addObject("listCustomer",customerService.getCustomersByAccountStatusAndNameContaining(search, false, pageable));
	
			paging.setSearch(search);
			paging.setTotalItem(customerService.getQuantityCustomersByAccountStatusAndNameContaining(search, false));
			paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
			mav.addObject("paging", paging);
			return mav;
		}

		mav.addObject("listCustomer", customerService.getCustomersAccountStatus(false, pageable));

		paging.setTotalItem(customerService.getQuantityOfCustomer(false));
		paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
		mav.addObject("paging", paging);

		return mav;
	}
	

}
