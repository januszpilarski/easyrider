package com.jpl.easyrider.InterfaceServices;

import com.jpl.easyrider.domain.User;
import com.jpl.easyrider.dto.UserDtoIngoing;
import com.jpl.easyrider.dto.UserDtoOutgoing;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    List<UserDtoOutgoing> findAllByRole(String role);

    User registerNewUserAccount(UserDtoIngoing userDto);

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    User findUserByEmail(String email);

    Optional<User> getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);
}
