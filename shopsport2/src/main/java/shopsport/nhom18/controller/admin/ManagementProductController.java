package shopsport.nhom18.controller.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.model.Category;
import shopsport.nhom18.model.Paging;
import shopsport.nhom18.model.Product;
import shopsport.nhom18.repository.ProductRepository;
import shopsport.nhom18.service.AccountService;
import shopsport.nhom18.service.CategoryService;
import shopsport.nhom18.service.ProductService;
import shopsport.nhom18.utils.ProductUpdateValidator;
import shopsport.nhom18.utils.ProductValidator;
import shopsport.nhom18.utils.SecurityUtils;

@Controller
@RequestMapping("/admin/management/product/")
public class ManagementProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductValidator productValidator;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductUpdateValidator productUpdateValidator;

	@GetMapping(path = { "list", "remove" })
	public ModelAndView showPageListProdcut(@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "1") int limit) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/product/list-product");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		Paging paging = new Paging();
		paging.setPage(page);
		paging.setMaxPageItem(limit);
		Pageable pageable = new PageRequest(page - 1, limit);

		if (id != null) {
			productService.delete(id);
		}

		if (search != null) {
			mav.addObject("listProduct", productService.getListProductByIdContainingAndStatus(search, false,pageable));
			paging.setSearch(search);
			paging.setTotalItem(productService.getQuantityOfProductByIdContainingAndStatus(search,false));
			paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
			mav.addObject("paging", paging);
			return mav;
		}

		mav.addObject("listProduct", productService.getListProductAndStatus(false,pageable));
		paging.setTotalItem(productService.getQuantityOfProductAndStatus(false));
		paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getMaxPageItem()));
		mav.addObject("paging", paging);

		return mav;
	}

	@GetMapping("add")
	public ModelAndView showPageAddProdcut() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/product/add-product");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);
		Product product = new Product();
		mav.addObject("addProdcut", product);
		return mav;
	}

	@PostMapping("add")
	public ModelAndView addProdcut(@ModelAttribute("addProdcut") Product product, BindingResult bindingResult,
			@RequestParam("avatar") MultipartFile avatar) {
		ModelAndView mav = new ModelAndView();
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);
		mav.setViewName("/admin/product/add-product");
		String message = "";
		String error = "";

		productValidator.validate(product, bindingResult);

		if (avatar.getOriginalFilename() == "") {
			error = "This field is required";
			mav.addObject("error", error);
			return mav;
		}

		if (bindingResult.hasErrors()) {
			message = "Thêm sản phẩm thất bại";
			mav.addObject("message", message);
			return mav;
		}

		product.setImage(avatar.getOriginalFilename());

		productService.save(product);

//		try {
//			MultipartFile multipartFile = avatar;
//			String fileName = multipartFile.getOriginalFilename();
//			File file = new File("D:\\java\\CongNghePhanMem\\shopsport2\\src\\main\\webapp\\templates\\images",
//					fileName);
//			multipartFile.transferTo(file);
//			message = "Thêm sản phẩm thành công";
//			mav.addObject("message", message);
//		} catch (Exception e) {
//			e.printStackTrace();
//			mav.addObject("message", "Lưu file ảnh thất bại");
//		}
//		
		if ( avatar != null) {
			try {
				MultipartFile multipartFile = avatar;
				String fileName = multipartFile.getOriginalFilename();
				String url = "D:\\java\\CongNghePhanMem\\shopsport2\\src\\main\\webapp\\templates\\images" + product.getImage();
				File tempFile = new File(url);
				if (!tempFile.exists()) {
					File file = new File(
							"D:\\java\\CongNghePhanMem\\shopsport2\\src\\main\\webapp\\templates\\images",
							fileName);
					multipartFile.transferTo(file);
				}
			} catch (Exception e) {
				e.printStackTrace();
				mav.addObject("message", "Lưu file ảnh thất bại");
			}
		}
		mav.addObject("message", "Lưu sản phẩm thành công");
		return mav;
	}

	@GetMapping("edit")
	public ModelAndView showPageEditProdcut(@RequestParam(name = "id", required = false) String id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/product/edit-product");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);
		Product product = productService.getProductById(id);
		mav.addObject("editProdcut", product);
		return mav;
	}

	@PostMapping("edit")
	public ModelAndView editProdcut(@ModelAttribute("editProdcut") Product product,
			@RequestParam(name = "id", required = false) String id, BindingResult bindingResult,
			@RequestParam("avatar") MultipartFile avatar) {
		ModelAndView mav = new ModelAndView();
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		mav.addObject("u", inforUser);
		mav.setViewName("/admin/product/edit-product");
		String message = "";
		String error = "";
		String errorName = "";
		
		Product product3 = productService.getProductById(id);
		
		if( productRepository.findOneByName(product.getName()) != null && !product3.getName().equals(product.getName())) {
			errorName = "name exist";
			message = "cập nhật thất bại";
			mav.addObject("message", message);
			mav.addObject("errorName", errorName);
			return mav;
		}

		productUpdateValidator.validate(product, bindingResult);

//		if (avatar.getOriginalFilename() == "") {
//			error = "This field is required";
//			mav.addObject("error", error);
//			return mav;
//		}

		if (bindingResult.hasErrors()) {
			message = "Cập nhật sản phẩm thất bại";
			mav.addObject("message", message);
			return mav;
		}

		product.setImage(avatar.getOriginalFilename());
		
		Product product2 = productService.update(product,id);
		
		if ( avatar != null) {
			try {
				String url = "D:\\java\\CongNghePhanMem\\shopsport2\\src\\main\\webapp\\templates\\images\\" + product2.getImage();
				File tempFile = new File(url);
				if (!tempFile.exists()) {
					MultipartFile multipartFile = avatar;
					String fileName = multipartFile.getOriginalFilename();
					File file = new File(
							"D:\\java\\CongNghePhanMem\\shopsport2\\src\\main\\webapp\\templates\\images",
							fileName);
					multipartFile.transferTo(file);
				}
			} catch (Exception e) {
				e.printStackTrace();
				mav.addObject("message", "Lưu file ảnh thất bại");
			}
		}

		message = "Cập nhật sản phẩm thành công";
		mav.addObject("message", message);
		return mav;
	}

	@ModelAttribute("categorys")
	public List<Category> getCategories() {
		List<Category> list = new ArrayList<Category>();
		list.addAll(categoryService.getAll());
		return list;
	}
}
