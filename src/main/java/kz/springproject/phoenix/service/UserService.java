package kz.springproject.phoenix.service;

import kz.springproject.phoenix.model.Permission;
import kz.springproject.phoenix.model.User;
import kz.springproject.phoenix.repository.PermissionRepository;
import kz.springproject.phoenix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public User addUser(User user) {
        User checkUser = userRepository.findByUsername(user.getUsername());
        if (checkUser == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            Permission userRole = permissionRepository.findById(2L)
                    .orElseThrow(() -> new UsernameNotFoundException("Role USER not found"));
            user.setPermissions(Arrays.asList(userRole));

            return userRepository.save(user);
        }
        return null;
    }
}
