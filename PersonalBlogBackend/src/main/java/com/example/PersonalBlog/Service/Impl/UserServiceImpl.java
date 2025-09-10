package com.example.PersonalBlog.Service.Impl;

import com.example.PersonalBlog.Model.Role;
import com.example.PersonalBlog.Model.User;
import com.example.PersonalBlog.Repository.RoleRepository;
import com.example.PersonalBlog.Repository.UserRepository;
import com.example.PersonalBlog.Service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(String username, String password, Set<String> roleNames) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exist!!!");
        }

        String encodedPassword = passwordEncoder.encode(password);

        Set<Role> roles = roleNames.stream()
                .map(roleName -> roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role Not Found: " + roleName)))
                .collect(Collectors.toSet());

        User user = new User(username, encodedPassword , roles);
        return userRepository.save(user);
    }
}
