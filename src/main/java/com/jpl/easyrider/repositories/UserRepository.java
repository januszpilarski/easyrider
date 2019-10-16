package com.jpl.easyrider.repositories;

import com.jpl.easyrider.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query("select u from User u inner join u.roles r where r.name=:role")
    List<User> findAllByRoles(@Param("role") String role);

    @Override
    void delete(User user);
}
