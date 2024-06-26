package shopsport.nhom18.controller.admin;

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
import shopsport.nhom18.model.Category;
import shopsport.nhom18.model.Paging;
import shopsport.nhom18.service.AccountService;
import shopsport.nhom18.service.CategoryService;
import shopsport.nhom18.utils.CategoryUpdateValiation;
import shopsport.nhom18.utils.CategoryValiation;
import shopsport.nhom18.utils.SecurityUtils;

@Controller
@RequestMapping("/admin/management/category/")
public class ManagementCategoryController {
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryValiation categoryValiation;
	
	@Autowired
	private CategoryUpdateValiation categoryUpdateValiation;
	
	@Autowired
	private AccountService accountService;

	@GetMapping(path = {"list","remove"})
	public ModelAndView showListCategory(
			@RequestParam(name = "idc", required = false) String id,
			@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "1") int limit) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/category/list-category");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);
		Paging paging = new Paging();
		paging.setPage(page);
		paging.setMaxPageItem(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		mav.addObject("check", false);
		if (id != null) {
			Category category = categoryService.getCategoryById(id);
			if(category.getListProdcut().size() == 0 ) {
				categoryService.delete(id);
			} else {
				mav.addObject("error", "Trong thể loại này có sản phẩm");
				mav.addObject("check", true);
			}
			
		}
		
		if(search != "") {
			mav.addObject("listCategory",categoryService.getListCategoryByIdContainingAndStatus(search,false, pageable));
			paging.setSearch(search);
			paging.setTotalItem(categoryService.getQuantityOfCategoryByIdContainingAndStatus(search,false));
			paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
			mav.addObject("paging", paging);
			return mav;
		}
		
		mav.addObject("listCategory", categoryService.getListCategoryAndStatus(false,pageable));
		paging.setTotalItem(categoryService.getQuantityOfCategoryAndStatus(false));
		paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
		mav.addObject("paging", paging);

		return mav;
	}

	@GetMapping("add")
	public ModelAndView showPageAddCategory() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/category/add-category");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);
		Category category = new Category();
		mav.addObject("addCategory", category);
		return mav;
	}

	@PostMapping("add")
	public ModelAndView doAddCategory(@ModelAttribute("addCategory") Category category, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/category/add-category");
		String message = "";
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);
		categoryValiation.validate(category, bindingResult);

		if (bindingResult.hasErrors()) {

			message = "Thêm thể loại thất bại";
			mav.addObject("message", message);
			return mav;
		}

		categoryService.save(category);

		message = "Thêm thể loại thành công";
		mav.addObject("message", message);
		return mav;
	}
	
	@GetMapping("edit")
	public ModelAndView showPageEditCategory(@RequestParam(name = "idc", required = false) String id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/category/edit-category");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);
		Category category = categoryService.getCategoryById(id);
		mav.addObject("editCategory", category);
		return mav;
	}
	
	@PostMapping("edit")
	public ModelAndView doEditCategory(@ModelAttribute("editCategory") Category category,BindingResult bindingResult,@RequestParam(name = "idc", required = false) String id ) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/category/edit-category");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);
		String message = "";
		
		categoryUpdateValiation.validate(category, bindingResult);

		if (bindingResult.hasErrors()) {

			message = "Cập nhật loại thất bại";
			mav.addObject("message", message);
			return mav;
		}

		categoryService.update(category,id);

		message = "Cập nhật thể loại thành công";
		mav.addObject("message", message);
		
		return mav;
	}
}
