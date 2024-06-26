package shopsport.nhom18.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.model.Paging;
import shopsport.nhom18.model.Role;
import shopsport.nhom18.model.Staff;
import shopsport.nhom18.repository.AccountRepository;
import shopsport.nhom18.service.AccountService;
import shopsport.nhom18.service.RoleService;
import shopsport.nhom18.service.StaffService;
import shopsport.nhom18.utils.RegisterStaffValidatior;
import shopsport.nhom18.utils.SecurityUtils;
import shopsport.nhom18.utils.UpdateStaffValidator;

@Controller
@RequestMapping("/admin/management/staff/")
public class ManagementStaffController {
	@Autowired
	private RoleService roleService;

	@Autowired
	private RegisterStaffValidatior registerStaffValidatior;

	@Autowired
	private UpdateStaffValidator updateStaffValidator;

	@Autowired
	private AccountService accountService;

	@Autowired
	private StaffService staffService;

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping(path = { "list", "remove" })
	public ModelAndView showListStaff(@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "1") int limit, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/staff/list-staff");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);

		Paging paging = new Paging();
		paging.setPage(page);
		paging.setMaxPageItem(limit);
		Pageable pageable = new PageRequest(page - 1, limit);

		if (id != null) {
			Account account = accountService.getAccountById(id);

			if (account.getStaff().getReceipts().size() == 0 || account.getStaff().getOders().size() == 0) {
				accountService.remove(id);
			} else {
				accountService.deleteAccount(id);
			}

		}

		if (search != "") {
			mav.addObject("listStaff",
					staffService.getCustomersByAccountStatusAndNameContaining(search, false, pageable));
			paging.setSearch(search);
			paging.setTotalItem(staffService.getQuantityCustomersByAccountStatusAndNameContaining(search, false));
			paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
			mav.addObject("paging", paging);
			return mav;
		}

		mav.addObject("listStaff", staffService.getStaffsAccountStatus(false, pageable));

		paging.setTotalItem(staffService.getQuantityOfStaff(false));
		paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
		mav.addObject("paging", paging);

		return mav;
	}

	@PostMapping("/edit")
	public ModelAndView doEdit(@ModelAttribute("updateStaff") Account account, BindingResult bindingResult,
			@RequestParam("id") String id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/staff/edit-staff");
		updateStaffValidator.validate(account, bindingResult);
		String message = "";
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);

		if (bindingResult.hasErrors()) {
			message = "cập nhật thất bại";
			mav.addObject("message", message);
			return mav;
		}

		accountService.updateStaff(account, id);
		message = "cập nhật thành công";
		mav.addObject("message", message);
		return mav;
	}

	@GetMapping("/edit")
	public ModelAndView showPageRegister(@RequestParam(name = "id", required = false) String id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/staff/edit-staff");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);
		Account account = accountService.getAccountById(id);
		mav.addObject("updateStaff", account);
		return mav;
	}

	@GetMapping("/add")
	public ModelAndView showPageEdit() {
		ModelAndView mav = new ModelAndView();
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);
		mav.setViewName("admin/register/register-admin");
		Account account = new Account();
		Staff staff = new Staff();
		account.setStaff(staff);
		mav.addObject("staffForm", account);
		return mav;
	}

	@PostMapping("/add")
	public ModelAndView doRegister(@ModelAttribute("staffForm") Account account, BindingResult bindingResult,
			@RequestParam("passwordConfirm") String password) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/register/register-admin");
		String message = "";
		String message2 = "";
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);

		registerStaffValidatior.validate(account, bindingResult);

		mav.addObject("checkPassword", false);

		if (!password.equals(account.getPassword())) {
			mav.addObject("checkPassword", true);
			mav.addObject("error", "Xac nhan mat khau that bai");
			message = "Đăng kí thất bại";
			mav.addObject("message1", message);
			return mav;
		}

		if (bindingResult.hasErrors()) {
			message = "Đăng kí thất bại";
			mav.addObject("message1", message);
			return mav;
		}

		accountService.registerStaff(account);
		message2 = "Đăng kí thành công";
		mav.addObject("message2", message2);
		return mav;
	}

	@ModelAttribute("roles")
	public List<Role> getRoles() {
		List<Role> roles = new ArrayList<Role>();
		List<String> strRoles = new ArrayList<String>();
		strRoles.add("ADMIN");
		strRoles.add("SALE");
		for (String string : strRoles) {
			if (roleService.findByName(string) != null) {
				roles.add(roleService.findByName(string));
			} else {
				Role role = new Role();
				role.setName(string);
				roles.add(roleService.save(role));
			}
		}
		return roles;
	}
}
