package com.jpl.easyrider.repositories;

import com.jpl.easyrider.domain.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
