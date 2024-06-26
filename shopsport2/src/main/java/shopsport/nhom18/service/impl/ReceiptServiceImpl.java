package shopsport.nhom18.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.Account;
import shopsport.nhom18.model.DetailsReceipt;
import shopsport.nhom18.model.DetailsReceiptPK;
import shopsport.nhom18.model.Product;
import shopsport.nhom18.model.Receipt;
import shopsport.nhom18.repository.AccountRepository;
import shopsport.nhom18.repository.DetailsReceiptRepository;
import shopsport.nhom18.repository.ProductRepository;
import shopsport.nhom18.repository.ReceiptRepository;
import shopsport.nhom18.repository.SupplierRepository;
import shopsport.nhom18.service.ReceiptService;
import shopsport.nhom18.utils.RandomStringGenerator;
import shopsport.nhom18.utils.SecurityUtils;

@Service
public class ReceiptServiceImpl implements ReceiptService {
	@Autowired
	private ReceiptRepository receiptRepository;

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private DetailsReceiptRepository detailsReceiptRepository;

	@Autowired
	private AccountRepository accountRepository;
	

	@Override
	public List<Receipt> getAll() {
		return receiptRepository.findAll();
	}

	@Override
	public Receipt save(Receipt receipt) {
		
		Account account = accountRepository.findOne(SecurityUtils.getPrincipal().getUsername());
		receipt.setStaff(account.getStaff());
		receiptRepository.save(receipt);
		
		double sum = 0;
		for (DetailsReceipt dr : receipt.getDetailsReceipts()) {
			Product product = productRepository.findOne(dr.getProduct().getId());
			DetailsReceipt detailsReceipt = new DetailsReceipt();
			detailsReceipt.setQuantity(dr.getQuantity());
			detailsReceipt.setPriceImport(dr.getPriceImport());
			detailsReceipt.setProduct(product);
			detailsReceipt.setReceipt(receipt);
			DetailsReceiptPK detailsReceiptPK = new DetailsReceiptPK(product.getId(), receipt.getId());
			detailsReceipt.setId(detailsReceiptPK);
			sum += detailsReceipt.getQuantity() * detailsReceipt.getPriceImport();
			product.setQuantity(product.getQuantity()+ dr.getQuantity());
			productRepository.save(product);
			detailsReceiptRepository.save(detailsReceipt);
		}

		receipt.setSumMoney(sum);

		receiptRepository.save(receipt);

		return null;
	}

	@Override
	public void delete(String id) {
		Receipt receipt = receiptRepository.findOne(id);

		for (DetailsReceipt dr : receipt.getDetailsReceipts()) {
			Product product = productRepository.findOne(dr.getProduct().getId());
			product.setQuantity(product.getQuantity() - dr.getQuantity());
			productRepository.save(product);
			detailsReceiptRepository.delete(dr);
		}

		receiptRepository.delete(id);
	}

	@Override
	public List<Receipt> getListReceipt(Pageable pageable) {
		return receiptRepository.findAll(pageable).getContent();
	}

	@Override
	public Integer getQuantityOfReceipt() {
		return receiptRepository.findAll().size();
	}

	@Override
	public List<Receipt> getListReceiptByIdContaining(String search, Pageable pageable) {
		return receiptRepository.findByIdContaining(search, pageable).getContent();
	}

	@Override
	public Integer getQuantityOfReceiptByIdContaining(String search) {
		return receiptRepository.findByIdContaining(search).size();
	}

	@Override
	public Receipt getById(String id) {
		return receiptRepository.findOne(id);
	}

	@Override
	public Receipt update(Receipt receipt, String id) {
		Receipt receipt2 = receiptRepository.findOne(id);
		
		for (DetailsReceipt dr : receipt2.getDetailsReceipts()) {
			dr.setReceipt(null);
			detailsReceiptRepository.save(dr);
			detailsReceiptRepository.delete(dr);
		}
		
		receipt2.setDate(receipt.getDate());
		receipt2.setSupplier(receipt.getSupplier());
		receipt2.setStaff(accountRepository.findOne(SecurityUtils.getPrincipal().getUsername()).getStaff());
		
		
		double sum = 0;
		List<DetailsReceipt> list = new ArrayList<DetailsReceipt>();
		for (DetailsReceipt dr : receipt.getDetailsReceipts()) {
			Product product = productRepository.findOne(dr.getProduct().getId());
			DetailsReceipt detailsReceipt = new DetailsReceipt();
			detailsReceipt.setQuantity(dr.getQuantity());
			detailsReceipt.setPriceImport(dr.getPriceImport());
			detailsReceipt.setProduct(product);
			detailsReceipt.setReceipt(receipt2);
			DetailsReceiptPK detailsReceiptPK = new DetailsReceiptPK(product.getId(), receipt2.getId());
			sum += detailsReceipt.getQuantity() * detailsReceipt.getPriceImport();
			DetailsReceipt detailsReceipt2 = detailsReceiptRepository.save(detailsReceipt);	
			list.add(detailsReceipt2);
		}
		
		receipt2.setSumMoney(sum);
		
		receipt2.setDetailsReceipts(list);
		
		return receiptRepository.save(receipt2);
	}

	@Override
	public List<Object[]> getCountByImportDateBetween(Date startDate, Date endDate) {
		return receiptRepository.countByImportDateBetween(startDate, endDate);
	}

}
