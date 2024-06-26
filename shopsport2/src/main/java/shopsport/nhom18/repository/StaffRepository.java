package shopsport.nhom18.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import shopsport.nhom18.model.Customer;
import shopsport.nhom18.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, String> {
	
	List<Staff> findByAccountStatus(boolean b);

	Staff findOneByCmnd(String cmnd);
	
	Staff findOneByName(String name);

	Page<Staff> findByAccountStatus(boolean b, Pageable pageable);

	Page<Staff> findByAccountStatusAndIdContaining(boolean b, String id, Pageable pageable);

	List<Staff> findByAccountStatusAndIdContaining(boolean b, String id);
}
