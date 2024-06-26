package shopsport.nhom18.service;

import shopsport.nhom18.model.Role;

public interface RoleService {
	Role findByName(String name);
	Role save(Role role);
}
