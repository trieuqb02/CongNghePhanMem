package shopsport.nhom18.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.model.DetailsReceipt;
import shopsport.nhom18.model.Receipt;
import shopsport.nhom18.service.AccountService;
import shopsport.nhom18.service.ReceiptService;
import shopsport.nhom18.utils.SecurityUtils;

@Controller
@RequestMapping("/admin/management/statistical/")
public class ManagementStatisticalController {
	@Autowired
	private ReceiptService receiptService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("revenu")
	public ModelAndView showPageRevenu() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@GetMapping("receipt")
	public ModelAndView showPageInventory() {
		ModelAndView mav = new ModelAndView("admin/statistical/inventory");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		 mav.addObject("check", false);
		return mav;
	}
	
	@PostMapping("receipt")
	public ModelAndView showStatistical(HttpServletRequest request,@RequestParam("fromDate") String formDate, @RequestParam("toDate") String toDate) throws ParseException {
		ModelAndView mav = new ModelAndView("admin/statistical/inventory");
		Account inforUser = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		mav.addObject("u", inforUser);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date Date1 = dateFormat.parse(formDate);
		Date Date2 = dateFormat.parse(toDate);
		String message1 = "";
		String message2 = "";
		if (Date2.after(new Date())) {
			message2 = "Ngày kết thúc vượt quá ngày hiện tại";
			
		} else if (Date1.after(Date2)) {
			message1 = "Ngày hiện tại vượt quá ngày kết thúc";
		} 
		
		if (!message1.equals("") || !message2.equals("") ) {
			mav.addObject("message1", message1);
			mav.addObject("message2", message2);
			return mav;
		}
		
		List<String> labels = new ArrayList<>();
	    List<Long> counts = new ArrayList<>();
	    List<Long> revenus = new ArrayList<>();
	    List<Object[]> data = receiptService.getCountByImportDateBetween(Date1,Date2);
	    List<Receipt> listReceipt = new ArrayList<Receipt>();
	    
	    for (Object[] row : data) {
	    	Receipt receipt = (Receipt) row[0];
	    	System.out.println(receipt.getDetailsReceipts().size());
	    	listReceipt.add(receipt);
	    	Long quantity = 0l;
	    	for (DetailsReceipt dr : receipt.getDetailsReceipts()) {
	    		quantity += dr.getQuantity();
			}
	    	
	    	counts.add(quantity);
	    	
	    	revenus.add((long) receipt.getSumMoney());
	    	
	    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	    	String strDate = formatter.format(row[1]);
	    	labels.add(strDate);
		}
	    
	    for (Receipt receipt : listReceipt) {
	    	System.out.println(receipt.getDetailsReceipts().size());
		}
	    
	    mav.addObject("listReceipt", listReceipt);
	    mav.addObject("labels", labels);
	    mav.addObject("counts", counts);
	    mav.addObject("revenus", revenus);
	    mav.addObject("check", true);
		return mav;
	}
}
