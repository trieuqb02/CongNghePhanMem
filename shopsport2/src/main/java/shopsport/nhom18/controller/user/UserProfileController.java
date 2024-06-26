package shopsport.nhom18.controller.user;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.model.Customer;
import shopsport.nhom18.repository.CustomerRepository;
import shopsport.nhom18.service.AccountService;
import shopsport.nhom18.service.CustomerService;
import shopsport.nhom18.utils.SecurityUtils;
@Controller
public class UserProfileController {
	
	@Autowired 
	private AccountService accountService;
	
	@Autowired 
	private CustomerService customerService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping("profile")
	public ModelAndView getProfileUser() {
		
		
		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		
		Customer customer = customerService.findOneByAccountUsername(account.getUsername());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("customer", customer);
		mav.setViewName("/users/profile");
		return mav;
	}
	
	@RequestMapping("profile/edit")
	public ModelAndView editProfileUser() {
		
		
		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		
		Customer customer = customerService.findOneByAccountUsername(account.getUsername());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("customer", customer);
		mav.setViewName("/users/editprofile");
		return mav;
	}
	
	@PostMapping("/profile/edit")
	public ModelAndView editProfile(@ModelAttribute("customer") Customer customer ,@RequestParam("avatar") MultipartFile avatar,
			@RequestParam("ids") String ids) {
		ModelAndView mav = new ModelAndView();
		
		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		
		customer.setImage(avatar.getOriginalFilename());
		customer.setId(ids);
		customer.setAccount(account);
		System.out.println(customer.getSurname());
		System.out.println(customer.getName());
		customerRepository.save(customer);
		
		String message = "";
		mav.setViewName("/users/editprofile");
		try {
			MultipartFile multipartFile = avatar;
			String fileName = multipartFile.getOriginalFilename();
			File file = new File("D:\\DOANCMPM\\shopsport2\\src\\main\\webapp\\templates\\images\\",
					fileName);
			multipartFile.transferTo(file);
			message = "Thêm sản phẩm thành công";
			mav.addObject("message", message);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("message", "Lưu file ảnh thất bại");
		}
		mav.setViewName("/users/editprofile");
		return mav;
	}
}
