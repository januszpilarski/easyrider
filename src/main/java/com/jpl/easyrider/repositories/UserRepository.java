package com.jpl.easyrider.repositories;

import com.jpl.easyrider.domain.Role;
import com.jpl.easyrider.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findAllByRoles(Role role);

    @Override
    void delete(User user);
}
