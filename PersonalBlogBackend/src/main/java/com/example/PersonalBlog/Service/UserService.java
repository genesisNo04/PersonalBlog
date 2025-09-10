package com.example.PersonalBlog.Service;

import com.example.PersonalBlog.Model.Role;
import com.example.PersonalBlog.Model.User;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface UserService {
    User createUser(String username, String password, Set<String> roleName);
}
