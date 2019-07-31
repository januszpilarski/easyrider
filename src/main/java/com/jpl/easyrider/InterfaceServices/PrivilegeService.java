package com.jpl.easyrider.InterfaceServices;

import com.jpl.easyrider.domain.Privilege;

public interface PrivilegeService {

    Privilege findByName(String name);

    void delete(Privilege privilege);
}
