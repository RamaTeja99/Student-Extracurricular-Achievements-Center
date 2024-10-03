package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User loginData) {
        String username = loginData.getUsername();
        String password = loginData.getPassword();
        String role = loginData.getRole();

        User authenticatedUser = userService.authenticate(username, password, role);

        return authenticatedUser != null ? 
               ResponseEntity.ok(authenticatedUser) : 
               ResponseEntity.status(401).body(null);
    }
    
}
