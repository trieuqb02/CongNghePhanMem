package shopsport.nhom18.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.Staff;
import shopsport.nhom18.repository.StaffRepository;
import shopsport.nhom18.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	private StaffRepository staffRepository;

	@Override
	public int getQuantityOfStaff(boolean b) {
		return  staffRepository.findByAccountStatus(b).size();
	}

	@Override
	public List<Staff> getStaffsAccountStatus(boolean b, Pageable pageable) {
		return staffRepository.findByAccountStatus(b, pageable).getContent();
	}

	@Override
	public List<Staff> getCustomersByAccountStatusAndNameContaining(String id, boolean b, Pageable pageable) {
		return staffRepository.findByAccountStatusAndIdContaining(b, id, pageable).getContent();
	}

	@Override
	public int getQuantityCustomersByAccountStatusAndNameContaining(String id, boolean b) {
		return staffRepository.findByAccountStatusAndIdContaining(b,id).size();
	}

}
