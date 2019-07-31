package com.jpl.easyrider.Services;


import com.jpl.easyrider.InterfaceServices.UserService;
import com.jpl.easyrider.domain.User;
import com.jpl.easyrider.dto.UserDto;
import com.jpl.easyrider.repositories.PrivilegeRepository;
import com.jpl.easyrider.repositories.RoleRepository;
import com.jpl.easyrider.repositories.UserRepository;
import com.jpl.easyrider.web.error.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User registerNewUserAccount(final UserDto userDto) {

        if (checkIfEmailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + userDto.getEmail());
        }

        final User user = new User();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public void saveRegisteredUser(User user) {

    }

    @Override
    public void deleteUser(final User user) {

        userRepository.delete(user);
    }

    @Override
    public User findUserByEmail(final String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> getUserByID(final long id) {
        return userRepository.findById(id);
    }

    @Override
    public void changeUserPassword(User user, String password) {

    }

    @Override
    public boolean checkIfValidOldPassword(User user, String password) {
        return false;
    }

    private boolean checkIfEmailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }
}
