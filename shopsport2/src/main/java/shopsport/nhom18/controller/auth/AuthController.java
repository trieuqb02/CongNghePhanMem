package shopsport.nhom18.controller.auth;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.model.Customer;
import shopsport.nhom18.model.Roles;
import shopsport.nhom18.service.impl.AccountServiceImpl;
import shopsport.nhom18.utils.RegisterValidator;

@Controller(value = "auth")
public class AuthController {

	@Autowired
	private AccountServiceImpl userService;
	
	@Autowired
    private RegisterValidator userValidator;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView signin(Model model,@RequestParam(value ="incorrectAccount", defaultValue = "false") Boolean error) {
        ModelAndView mav = new ModelAndView("auth/login");
		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET )
	public ModelAndView logout(HttpServletRequest req,HttpServletResponse res) {
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(req, res, auth);
		}
		ModelAndView mav = new ModelAndView("redirect:/login");
		return mav;

	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET  )
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView("auth/register");
		Account account = new Account();
		Customer customer = new Customer();
		account.setCustomer(customer);
		mav.addObject("userForm", account);
		mav.addObject("check", false);
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("userForm") Account userForm,BindingResult bindingResult,@RequestParam("passwordConfirm") String password) {
		ModelAndView mav = new ModelAndView("auth/register");
		String message = "";
		userValidator.validate(userForm, bindingResult);
		mav.addObject("check", true);
		mav.addObject("checkPassword", false);
		
		if ( !password.equals(userForm.getPassword())) {
			mav.addObject("checkPassword", true);
			mav.addObject("error", "Xac nhan mat khau that bai");
			message = "Đăng kí thất bại";
			mav.addObject("message", message);
			return mav;
		}
		
		if (bindingResult.hasErrors()) {
			message = "Đăng kí thất bại";
			
			mav.addObject("message", message);
			
			return mav;
        }
		
//		List<String> strRoles = new ArrayList<String>();
//		strRoles.add(Roles.USER.toString());
		
		userService.registerUser(userForm,Roles.USER.toString());
		
		message = "Đăng kí thành công";
		mav.addObject("message", message);
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET )
	public ModelAndView accessDenied() {
		ModelAndView mav = new ModelAndView("denied");
		return mav;
	}
	
	
	

	
	
}
