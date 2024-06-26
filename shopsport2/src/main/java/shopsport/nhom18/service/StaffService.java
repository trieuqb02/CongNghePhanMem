package shopsport.nhom18.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import shopsport.nhom18.model.Staff;

public interface StaffService {
	int getQuantityOfStaff(boolean b);
	
	List<Staff> getStaffsAccountStatus(boolean b, Pageable pageable);
	
	List<Staff> getCustomersByAccountStatusAndNameContaining(String id, boolean b, Pageable pageable);
	
	int getQuantityCustomersByAccountStatusAndNameContaining(String id, boolean b);
}
