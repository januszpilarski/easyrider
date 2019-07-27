package com.jpl.easyrider.Services;

import com.jpl.easyrider.domain.Privilege;
import com.jpl.easyrider.domain.Role;
import com.jpl.easyrider.domain.User;
import com.jpl.easyrider.repositories.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDetailsTests {

    public static final String ROLE = "TEST_ROLE";
    public static final String PRIVILEGE = "TEST_PRIVILEGE";

    @Mock
    UserRepository userRepository;

    @InjectMocks
    MyUserDetailsService myUserDetailsService;

    private User initUser;

    @BeforeEach
    void initUser(){

        Privilege privilege = new Privilege();
        privilege.setId(1L);
        privilege.setName(PRIVILEGE);

        Role role = new Role();
        role.setId(1L);
        role.setName(ROLE);
        role.setPrivileges(Arrays.asList(privilege));

        initUser = new User();
        initUser.setId(1L);
        initUser.setEnabled(true);
        initUser.setEmail("test@example.com");
        initUser.setPassword("SecretPassword");
        initUser.setFirstName("First");
        initUser.setLastName("Last");
        initUser.setRoles(Arrays.asList(role));
    }

    @DisplayName("Test authorities verification")
    @Test()
    void should_load_user_by_username() {

        when(userRepository.findByEmail(anyString())).thenReturn(initUser);

        org.springframework.security.core.userdetails
                .UserDetails user = myUserDetailsService
                .loadUserByUsername("test@example.com");

        assertEquals("["+PRIVILEGE+", "+ROLE+"]", user.getAuthorities().toString());
    }
}