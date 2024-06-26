package shopsport.nhom18.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import shopsport.nhom18.model.Receipt;

public interface ReceiptService {
	List<Receipt> getAll();
	
	Receipt save(Receipt receipt);

	void delete(String id);
	
	List<Receipt> getListReceipt(Pageable pageable);

	Integer getQuantityOfReceipt();

	List<Receipt> getListReceiptByIdContaining(String search, Pageable pageable);

	Integer getQuantityOfReceiptByIdContaining(String search);

	Receipt getById(String id);

	Receipt update(Receipt receipt, String id);
	
	List<Object[]> getCountByImportDateBetween(Date startDate, Date endDate);
}
