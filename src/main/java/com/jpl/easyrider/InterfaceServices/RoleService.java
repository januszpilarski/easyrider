package com.jpl.easyrider.InterfaceServices;

import com.jpl.easyrider.domain.Role;

public interface RoleService {

    Role findByName(String name);

    void delete(Role role);
}
