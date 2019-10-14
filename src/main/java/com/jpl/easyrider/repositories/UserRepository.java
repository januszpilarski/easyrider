package com.jpl.easyrider.repositories;

import com.jpl.easyrider.domain.Role;
import com.jpl.easyrider.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.firstName like 'Adam'")
//    @Query("SELECT u.firstName, u.lastName FROM User u WHERE u.firstName like 'Adam'")
    List<User> findAllByRoles(String name);

    @Override
    void delete(User user);
}
