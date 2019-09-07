package com.jpl.easyrider.InterfaceServices;

import com.jpl.easyrider.domain.Role;
import com.jpl.easyrider.domain.User;
import com.jpl.easyrider.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    List<User> findAllByRoles(Role role);

    User registerNewUserAccount(UserDto userDto);

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    User findUserByEmail(String email);

    Optional<User> getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);
}
