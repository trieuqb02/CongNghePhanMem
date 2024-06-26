package shopsport.nhom18.controller.admin;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.model.MyUser;
import shopsport.nhom18.repository.AccountRepository;
import shopsport.nhom18.repository.StaffRepository;
import shopsport.nhom18.service.AccountService;
import shopsport.nhom18.utils.SecurityUtils;
import shopsport.nhom18.utils.UpdateValidator;

@Controller
@RequestMapping("/admin/")
public class ProfileController {
	@Autowired
	private AccountService accountService;

	@Autowired
	private UpdateValidator updateValidator;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private StaffRepository staffRepository;

	@GetMapping(value = "profile")
	public ModelAndView profile() {
		ModelAndView mav = new ModelAndView("admin/profile/profile");
		MyUser user = SecurityUtils.getPrincipal();

		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		return mav;
	}

	@GetMapping(value = "profile/update/{id}")
	public ModelAndView editProfile(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("admin/profile/edit-profile");

		Account inforUser = accountService.getAccountById(id);

		mav.addObject("u", inforUser);

		return mav;
	}

	@PostMapping(value = "profile/update/{id}")
	public ModelAndView doEditProfile(@PathVariable(name = "id") String id, @ModelAttribute("u") Account updateUser,
			BindingResult bindingResult, @RequestParam("avatar") MultipartFile avatar) {
		ModelAndView mav = new ModelAndView("admin/profile/edit-profile");
		String message = "";
		String error = "";
		String errorEmail = "";
		String errorCmnd = "";

		updateValidator.validate(updateUser, bindingResult);
		
		Account account2 = accountRepository.findOne(id);
		
		
		if (accountRepository.findOneByEmail(updateUser.getEmail()) != null &&  !account2.getEmail().equals(updateUser.getEmail())) {
			errorEmail = "email exist!";
			message = "cập nhật thất bại";
			mav.addObject("errorEmail", errorEmail);
			
		} 
		
		if (staffRepository.findOneByCmnd(updateUser.getStaff().getCmnd()) != null &&  !account2.getStaff().getCmnd().equals(updateUser.getStaff().getCmnd())) {
			errorCmnd = "cmnd exist!";
			message = "cập nhật thất bại";
			mav.addObject("errorCmnd", errorCmnd);
			
		} 
		
		if( errorEmail != "" || errorCmnd != "") {
			return mav;
		}

		if (bindingResult.hasErrors()) {
			message = "cập nhật thất bại";
			mav.addObject("error", error);
			return mav;
		}

		if (avatar.getOriginalFilename() != "") {
			updateUser.getStaff().setImage(avatar.getOriginalFilename());
		}

		Account account = accountService.updateAccount(updateUser, id);

		try {
			String url = "D:\\java\\CongNghePhanMem\\shopsport2\\src\\main\\webapp\\templates\\images" + account.getStaff().getImage();
			File tempFile = new File(url);
			if (!tempFile.exists()) {
				MultipartFile multipartFile = avatar;
				String fileName = multipartFile.getOriginalFilename();
				File file = new File(
						"D:\\java\\CongNghePhanMem\\shopsport2\\src\\main\\webapp\\templates\\images",
						fileName);
				//multipartFile.transferTo(file);
			}
			message = "cập nhật thành công";
			mav.addObject("message", message);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("message", "upload failed");
		}

		return mav;
	}

}
