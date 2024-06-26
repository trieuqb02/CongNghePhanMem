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
import shopsport.nhom18.model.Paging;
import shopsport.nhom18.model.Product;
import shopsport.nhom18.model.Supplier;
import shopsport.nhom18.repository.SupplierRepository;
import shopsport.nhom18.service.AccountService;
import shopsport.nhom18.service.SupplierService;
import shopsport.nhom18.utils.SecurityUtils;
import shopsport.nhom18.utils.SupplierUpdateVaditor;
import shopsport.nhom18.utils.SupplierValiation;

@Controller
@RequestMapping("/admin/management/supplier/")
public class ManagementSupplierController {
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private SupplierValiation supplierValiation;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private SupplierUpdateVaditor supplierUpdateVaditor;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@GetMapping(path = {"list","remove"})
	public ModelAndView showPageListSupplier(
			@RequestParam(name = "ids", required = false) String id,
			@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "1") int limit) {
		ModelAndView mav = new ModelAndView();
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		mav.setViewName("admin/supplier/list-supplier");
		
		Paging paging = new Paging();
		paging.setPage(page);
		paging.setMaxPageItem(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		
		if (id != null) {
			Supplier supplier = supplierService.getSupplier(id);
			
			if (supplier.getReceipts().size() != 0) {
				supplierService.delete(id);
			} else {
				supplierService.remove(id);
			}
			
		}
		
		if(search != "") {
			mav.addObject("listSupplier",supplierService.getListSupplierByIdContainingAndStatus(search,false, pageable));
			paging.setSearch(search);
			paging.setTotalItem(supplierService.getQuantityOfSupplierByIdContainingAndStatus(search,false));
			paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
			mav.addObject("paging", paging);
			return mav;
		}
		
		mav.addObject("listSupplier", supplierService.getListSupplierAndStatus(false,pageable));
		paging.setTotalItem(supplierService.getQuantityOfSupplierAndStatus(false));
		paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
		mav.addObject("paging", paging);
		
		return mav;
	}
	
	@GetMapping("add")
	public ModelAndView showPageAddSupplier() {
		ModelAndView mav = new ModelAndView();
		Supplier supplier = new Supplier();
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		mav.addObject("addSupplier", supplier);
		mav.setViewName("admin/supplier/add-supplier");
		return mav;
	}
	
	@PostMapping("add")
	public ModelAndView doAddSupplier(@ModelAttribute("addSupplier") Supplier supplier,BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/supplier/add-supplier");
		String message1 = "";
		String message2 = "";
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		
		supplierValiation.validate(supplier, bindingResult);

		if (bindingResult.hasErrors()) {

			message1 = "Thêm nhà cung cấp thất bại";
			mav.addObject("message1", message1);
			return mav;
		}

		supplierService.save(supplier);

		message2 = "Thêm nhà cung cấp thành công";
		mav.addObject("message2", message2);
		return mav;
	}
	
	@GetMapping("edit")
	public ModelAndView showPageEditCategory(@RequestParam(name = "ids", required = false) String id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/supplier/edit-supplier");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		Supplier supplier = supplierService.getSupplier(id);
		mav.addObject("editSupplier", supplier);
		return mav;
	}
	
	@PostMapping("edit")
	public ModelAndView doEditCategory(@ModelAttribute("editSupplier") Supplier supplier,BindingResult bindingResult,@RequestParam(name = "ids", required = false) String id ) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/supplier/edit-supplier");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		String message1 = "";
		String message2 = "";
		String errorName = "";
		
		Supplier supplier2 = supplierService.getSupplier(id);
		
		if( supplierRepository.findOneByName(supplier.getName()) != null && !supplier2.getName().equals(supplier.getName())) {
			errorName = "Ten da ton tai";
			message1 = "cập nhật thất bại";
			mav.addObject("message1", message1);
			mav.addObject("errorName", errorName);
			return mav;
		}
		
		supplierUpdateVaditor.validate(supplier, bindingResult);

		if (bindingResult.hasErrors()) {

			message1 = "cập nhật thất bại";
			mav.addObject("message1", message1);
			return mav;
		}

		supplierService.update(supplier,id);

		message2 = "cập nhật thành công";
		mav.addObject("message2", message2);
		
		return mav;
	}
}
