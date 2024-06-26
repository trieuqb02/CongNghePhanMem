package shopsport.nhom18.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shopsport.nhom18.model.Role;

public interface RoleRepository extends JpaRepository<Role, String>{
	Role findOneByName (String name);
	
}
