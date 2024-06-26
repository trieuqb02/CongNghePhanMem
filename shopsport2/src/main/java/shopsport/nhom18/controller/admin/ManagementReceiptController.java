package shopsport.nhom18.controller.admin;

import java.util.ArrayList;
import java.util.Date;
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
import shopsport.nhom18.model.DetailsReceipt;
import shopsport.nhom18.model.Paging;
import shopsport.nhom18.model.Product;
import shopsport.nhom18.model.Receipt;
import shopsport.nhom18.model.Supplier;
import shopsport.nhom18.repository.ReceiptRepository;
import shopsport.nhom18.service.AccountService;
import shopsport.nhom18.service.ProductService;
import shopsport.nhom18.service.ReceiptService;
import shopsport.nhom18.service.SupplierService;
import shopsport.nhom18.utils.SecurityUtils;

@Controller
@RequestMapping("/admin/management/receipt/")
public class ManagementReceiptController {
	@Autowired
	private ReceiptService receiptService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private ProductService productService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private ReceiptRepository receiptRepository;

	@GetMapping(path = { "list", "remove" })
	public ModelAndView showListReceipt(@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "1") int limit) {
		ModelAndView mav = new ModelAndView("admin/receipt/list-receipt");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		Paging paging = new Paging();
		paging.setPage(page);
		paging.setMaxPageItem(limit);
		Pageable pageable = new PageRequest(page - 1, limit);

		if (id != null) {
			receiptService.delete(id);
		}

		if (search != "") {
			mav.addObject("listReceipt", receiptService.getListReceiptByIdContaining(search, pageable));
			paging.setSearch(search);
			paging.setTotalItem(receiptService.getQuantityOfReceiptByIdContaining(search));
			paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
			mav.addObject("paging", paging);
			return mav;
		}

		mav.addObject("listReceipt", receiptService.getListReceipt(pageable));
		paging.setTotalItem(receiptService.getQuantityOfReceipt());
		paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
		mav.addObject("paging", paging);

		return mav;
	}

	@GetMapping("quantity")
	public ModelAndView show() {
		ModelAndView mav = new ModelAndView("admin/receipt/quantityDR-receipt");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		return mav;
	}

	@PostMapping("quantity")
	public ModelAndView showPageAddReceipt(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/receipt/add-receipt");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		String quantityDR = request.getParameter("quantityDR");

		String error = "";

		if (quantityDR.equals("")) {
			mav.setViewName("admin/receipt/quantityDR-receipt");
			error = "Truong nay duoc yeu cau";
			mav.addObject("error", error);
			return mav;

		} else if (Integer.valueOf(quantityDR) <= 0) {
			mav.setViewName("admin/receipt/quantityDR-receipt");
			error = "Nhap so lon hon 0";
			mav.addObject("error", error);
			return mav;
		}

		mav.addObject("error", error);

		Receipt receipt = new Receipt();
		List<DetailsReceipt> detailsReceipts = new ArrayList<DetailsReceipt>();

		System.out.println(Integer.valueOf(quantityDR));
		for (int i = 0; i < Integer.valueOf(quantityDR); i++) {
			DetailsReceipt detailsReceipt = new DetailsReceipt();
			detailsReceipts.add(detailsReceipt);
		}
		receipt.setDetailsReceipts(detailsReceipts);
		mav.addObject("receipt", receipt);
		return mav;
	}

	@PostMapping("add")
	public ModelAndView doAddReceipt(@ModelAttribute("receipt") Receipt receipt, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/receipt/add-receipt");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		String error = "";
		String message = "";
		if (receipt.getId().equals("")) {
			error = "Truong nay duoc yeu cau";
			mav.addObject("error", error);
			return mav;
		}
		
		if (receiptService.getById(receipt.getId()) != null) {
			error = "Ma da ton tai";
			mav.addObject("error", error);
			return mav;
		}

		receipt.setDate(new Date());
		receiptService.save(receipt);
		
		mav.addObject("message", "Luu thanh cong");

		return mav;
	}

	@GetMapping("edit")
	public ModelAndView showPageEdit(@RequestParam("idr") String id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/receipt/edit-receipt");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		Receipt receipt = receiptService.getById(id);
		mav.addObject("updateReceipt", receipt);
		return mav;
	}

	@PostMapping("edit")
	public ModelAndView doEdit(@RequestParam("idr") String id, @ModelAttribute("updateReceipt") Receipt receipt,
			BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/receipt/edit-receipt");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		Receipt receipt2 = receiptService.update(receipt, id);
		mav.addObject("updateReceipt", receipt2);
		return mav;
	}

	@ModelAttribute("suppliers")
	public List<Supplier> getListReceipt() {
		List<Supplier> list = supplierService.getAll();
		return list;
	}

	@ModelAttribute("products")
	public List<Product> getAllProdcut() {
		List<Product> list = productService.getAll();
		return list;
	}

}
