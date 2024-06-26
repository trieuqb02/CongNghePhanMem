package shopsport.nhom18.controller.cart;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.model.Cart;
import shopsport.nhom18.model.Category;
import shopsport.nhom18.model.DetailsOder;
import shopsport.nhom18.model.DetailsOderPk;
import shopsport.nhom18.model.DetailsProduct;
import shopsport.nhom18.model.DetailsProductPk;
import shopsport.nhom18.model.Order;
import shopsport.nhom18.model.Pay;
import shopsport.nhom18.model.Product;
import shopsport.nhom18.repository.DetailsOrderRepository;
import shopsport.nhom18.repository.OrderRepository;
import shopsport.nhom18.repository.Product_detailRepository;
import shopsport.nhom18.service.AccountService;
import shopsport.nhom18.service.CartDetailsService;
import shopsport.nhom18.service.CartService;
import shopsport.nhom18.service.CategoryService;
import shopsport.nhom18.service.DetailsOrderService;
import shopsport.nhom18.service.OrderService;
import shopsport.nhom18.service.PayService;
import shopsport.nhom18.service.ProductService;
import shopsport.nhom18.service.Product_detailService;
import shopsport.nhom18.utils.SecurityUtils;

@Controller
public class cart_controller {
	@Autowired
	private Product_detailService productDetailService;

	@Autowired
	private CartService cartservice;

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categotyService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private Product_detailRepository product_detailRepository;

	@Autowired
	private CartDetailsService cartDetailsService;
	
	@Autowired
	private PayService payService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderRepository orderRepository ;
	
	@Autowired
	private DetailsOrderRepository detailsOrderRepository ;
	
	@Autowired
	private DetailsOrderService detailsOrderService;

	@RequestMapping("/cart")
	public ModelAndView cart(@RequestParam(name = "id", required = false) String id) {
		// tạo mới một Cart_detail

		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		
		int possitionCart = account.getCustomer().getListCart().size() - 1;
		
		Long idCart = account.getCustomer().getListCart().get(possitionCart).getId();
		
		Cart cart = cartservice.getIdCart(idCart);

		Product product = productService.getProductById(id);

		DetailsProductPk ids = new DetailsProductPk(cart.getId(), product.getId());
		int count = 1;

		DetailsProduct productDetail = new DetailsProduct(ids, count, product, cart);

		// thêm mới Cart_detail vào giỏ hàng
		productDetailService.save(productDetail);

		// lấy danh sách Cart_detail trong giỏ hàng
//	    List<DetailsProduct> listproductDetails = productDetailService.getAll();
		System.out.println(cart.getId());
		List<DetailsProduct> listproductDetails = product_detailRepository.findByCartId(cart.getId());
		ModelAndView mv = new ModelAndView("/cart/cart");
		mv.addObject("cartDetails", listproductDetails);

		List<Category> category = categotyService.getAll();
		mv.addObject("category", category);
		return mv;
	}

	@PostMapping("/cart/remove")
	public ModelAndView removeCartDetail(@RequestParam("cartDetailId") Long cartDetailId,
			@RequestParam("productId") String productId) {
		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

int possitionCart = account.getCustomer().getListCart().size() - 1;
		
		Long idCart = account.getCustomer().getListCart().get(possitionCart).getId();
		
		Cart cart = cartservice.getIdCart(idCart);
		productDetailService.deleteByProductIdAndCartId(productId, cartDetailId);

		ModelAndView mv = new ModelAndView();
		List<DetailsProduct> listcart = product_detailRepository.findByCartId(cart.getId());
		mv.addObject("cartDetails", listcart);
		List<Category> category = categotyService.getAll();
		mv.addObject("category", category);
		mv.setViewName("/cart/cart");
		return mv;
	}

	@RequestMapping("/cart/list")
	public ModelAndView listcart() {
		ModelAndView mv = new ModelAndView("/cart/cart");

		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		int possitionCart = account.getCustomer().getListCart().size() - 1;
		
		Long idCart = account.getCustomer().getListCart().get(possitionCart).getId();
		
		Cart cart = cartservice.getIdCart(idCart);

		List<DetailsProduct> listcart = product_detailRepository.findByCartId(cart.getId());
		mv.addObject("cartDetails", listcart);

		List<Category> category = categotyService.getAll();
		mv.addObject("category", category);
		return mv;
	}

	@GetMapping(path = { "/cart/product/{idProduct}/except", "/cart/product/{idProduct}/add" })
	public ModelAndView changeQuantityOfProductInDetailsProduct(HttpServletRequest request,
			@PathVariable(name = "idProduct") String idProduct) {
		ModelAndView mav = new ModelAndView("/cart/cart");

		String url = request.getRequestURL().toString();

		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

int possitionCart = account.getCustomer().getListCart().size() - 1;
		
		Long idCart = account.getCustomer().getListCart().get(possitionCart).getId();
		
		Cart cart = cartservice.getIdCart(idCart);

		DetailsProduct detailsProduct = cartDetailsService.getCartDetailsById(cart.getId(), idProduct);

		if (url.contains("add")) {

			if (detailsProduct.getQuantity() < detailsProduct.getProduct().getQuantity()) {

				detailsProduct.setQuantity(detailsProduct.getQuantity() + 1);
			}
		} else {

			if (0 < detailsProduct.getQuantity()) {

				detailsProduct.setQuantity(detailsProduct.getQuantity() - 1);
			}

		}

		cartDetailsService.updateCartDetails(detailsProduct);

		List<DetailsProduct> listcart = product_detailRepository.findByCartId(cart.getId());
		mav.addObject("cartDetails", listcart);

		List<Category> category = categotyService.getAll();
		mav.addObject("category", category);
		return mav;
	}
	
	@GetMapping("cart/confirm")
	public ModelAndView confirmOrder() {
		ModelAndView mav = new ModelAndView("cart/ThankYou");
		
		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		
		if (account.getCustomer().getAddress() == null) {
			mav.setViewName("redirect:/profile/edit");
			return mav;
		}
		
		
		
		int possitionCart = account.getCustomer().getListCart().size() - 1;
		
		Long idCart = account.getCustomer().getListCart().get(possitionCart).getId();
		
		Cart cart = cartservice.getIdCart(idCart);
		
		List<DetailsProduct> listcart = product_detailRepository.findByCartId(cart.getId());
		if (listcart.isEmpty()) {
			mav.setViewName("/cart/cart");
			mav.addObject("masage", "vui lòng thêm sản phẩm vào giỏ hàng để mua");
			return mav;
		}
		
		Order order = new Order();
		Pay pay = payService.getPayById("1");
		order.setAddress(account.getCustomer().getAddress());
		order.setDate(new Date());
		order.setPhone(account.getCustomer().getPhone());
		order.setCustomer(account.getCustomer());
		order.setPay(pay);
		order.setStatus("Chờ xác nhận");
		order = orderService.save(order);
		

		
		for (DetailsProduct detailsProduct : listcart) {
			DetailsOder detailsOder = new DetailsOder();
			DetailsOderPk detailsOderPk = new DetailsOderPk(order.getId(), detailsProduct.getProduct().getId());
			detailsOder.setId(detailsOderPk);
			detailsOder.setProduct(detailsProduct.getProduct());
			detailsOder.setQuantity(detailsProduct.getQuantity());
			detailsOder.setPrice(detailsProduct.getProduct().getPrice());
			detailsOder.setOder(order);
			
			detailsOrderService.save(detailsOder);
			
			detailsProduct.getProduct().setQuantity(detailsProduct.getProduct().getQuantity() - detailsProduct.getQuantity());
			productService.save(detailsProduct.getProduct());
		}
		
		Cart newCart = new Cart();
		
		newCart.setCustomer(account.getCustomer());
		
		newCart = cartservice.save(newCart);
		
		return mav;
	}
	
	@GetMapping("/cart/orderlist")
	public ModelAndView getListOrder() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/cart/orderList");
		
		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getFullName());
		
		List<Order> orders = orderService.findAllByCustomer_Id(account.getCustomer().getId());
		
		mav.addObject("listOrder", orders);
		return mav;
	}
	
	@GetMapping("/order/details")
	public ModelAndView getOrderDetail(@RequestParam("ido") Long ido) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/cart/ortherDetail");
		
		Order order = orderService.findOneById(ido);
		
		List<DetailsOder> detailsOders = order.getDetailsOders();
		
		mav.addObject("detailsOders", detailsOders);
		return mav;
			
	}
	
	@GetMapping("/order/detailconfirm")
	public ModelAndView detailconfirm(@RequestParam("ido") Long ido) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/cart/orderlist");
		
		Order order = orderService.findOneById(ido);
		
		order.setStatus("Đã Hoàn thành");
		
		orderRepository.save(order);
		
		return mav;
			
	}
	
	@GetMapping("/order/delete")
	public ModelAndView deleteOrder(@RequestParam("ido") Long ido) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/cart/orderlist");
		
		Order order = orderService.findOneById(ido);
		
		List<DetailsOder> detailsOders = order.getDetailsOders();
		
		detailsOrderRepository.deleteInBatch(detailsOders);
		
		orderRepository.delete(ido);
		
		return mav;
			
	}
}
