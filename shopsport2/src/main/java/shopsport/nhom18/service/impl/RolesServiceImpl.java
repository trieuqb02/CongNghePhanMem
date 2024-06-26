package shopsport.nhom18.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopsport.nhom18.model.Role;
import shopsport.nhom18.repository.RoleRepository;
import shopsport.nhom18.service.RoleService;
import shopsport.nhom18.utils.RandomStringGenerator;

@Service
public class RolesServiceImpl implements RoleService{
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findByName(String name) {
		return roleRepository.findOneByName(name);
	}

	@Override
	public Role save(Role role) {
		role.setId(RandomStringGenerator.generateRandomString(10));
		return roleRepository.save(role);
	}

}
