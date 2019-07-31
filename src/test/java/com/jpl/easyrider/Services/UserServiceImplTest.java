package com.jpl.easyrider.Services;

import com.jpl.easyrider.repositories.RoleRepository;
import com.jpl.easyrider.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void registerNewUserAccount() {


    }

    @Test
    void deleteUser() {
    }

    @Test
    void findUserByEmail() {
    }

    @Test
    void getUserByID() {
    }

    @Test
    void changeUserPassword() {
    }
}