package shopsport.nhom18.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shopsport.nhom18.model.Category;
import shopsport.nhom18.model.Product;
import shopsport.nhom18.service.CategoryService;
import shopsport.nhom18.service.ProductService;

@Controller
@RequestMapping("/user")

public class User_controller {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categotyService;
	
	@RequestMapping(value = "/index" )
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView();
		List<Product> list = productService.getAll();
		mav.addObject("listProdcut", list);
		List<Category> category = categotyService.getByStatus(false);
		mav.addObject("category", category);
		mav.setViewName("users/index");
		
		return mav;
	}
	
	@RequestMapping("/list-view")
	public ModelAndView listview() {
		ModelAndView mv = new ModelAndView("users/list-view");
		return mv;
	}
	
	@RequestMapping("/grid-view")
	public ModelAndView gridview() {
		ModelAndView mv = new ModelAndView("users/grid-view");
		return mv;
	}
	
	@RequestMapping("/three-col")
	public ModelAndView threecol() {
		ModelAndView mv = new ModelAndView("users/three-col");
		return mv;
	}
	
	@RequestMapping("/four-col")
	public ModelAndView fourcol() {
		ModelAndView mv = new ModelAndView("users/four-col");
		return mv;
	}
	
	@RequestMapping("/general")
	public ModelAndView genaral() {
		ModelAndView mv = new ModelAndView("users/general");
		return mv;
	}
	
	@RequestMapping("/products")
	public ModelAndView product(@RequestParam(name ="id" , required = false) String id) {
		ModelAndView mv = new ModelAndView();
		List<Category> category = categotyService.getByStatus(false);
		List<Product> products = new ArrayList<>();
		if ( id == null) {
			products = productService.getAll();
			
		}
		else {
			products = productService.getProductByIdCategory(id);
		}
		
		mv.addObject("category", category);
		mv.addObject("products", products);
		mv.setViewName("users/products");
		return mv;
	}
	
	@RequestMapping("/product_details")
	public ModelAndView product_details(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("users/product_details");
		Product  product= productService.getProductById(id);
		List<Category> category = categotyService.getByStatus(false);
		mv.addObject("category", category);
		mv.addObject("product", product);
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("users/register");
		return mv;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("users/contact");
		return mv;
	}
	
	

}
