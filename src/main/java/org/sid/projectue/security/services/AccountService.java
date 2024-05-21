package org.sid.projectue.security.services;

import org.sid.projectue.security.entities.Role;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    User createUser(String username, String password, String email, String confirmPassword);
    Role createRole(String role);
    void addRoleToUser(String username, String role);
    void removeRoleFromUser(String username, String role);
    User loadUserByUsername(String username);
}
