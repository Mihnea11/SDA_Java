package com.movie.platform.server.controllers;

import com.movie.platform.server.models.User;
import com.movie.platform.server.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthenticationController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.createUser(user);

            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred. Please try again.");
        }
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        try {
            User user = userService.getUserByEmail(email);

            if (passwordEncoder.matches(password, user.getPassword())) {
                return ResponseEntity.ok("Login successful!");
            }
            else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
            }
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred. Please try again.");
        }
    }
}
