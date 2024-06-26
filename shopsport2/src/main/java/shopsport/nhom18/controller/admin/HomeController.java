package shopsport.nhom18.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.service.AccountService;
import shopsport.nhom18.service.CustomerService;
import shopsport.nhom18.service.StaffService;
import shopsport.nhom18.utils.SecurityUtils;

@Controller("admin")
@RequestMapping("/admin/")
public class HomeController {
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("home")
	public ModelAndView home(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("admin/home-admin");
		
		mav.addObject("quantityOfUser", customerService.getQuantityOfCustomer(false));
		
		mav.addObject("quantityOfStaff", staffService.getQuantityOfStaff(false));
		
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);
		return mav;
	}
}
