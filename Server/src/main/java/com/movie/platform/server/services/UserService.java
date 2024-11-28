package com.movie.platform.server.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.platform.server.models.User;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private static final String JSON_FILE = "users.json";
    private List<User> users = new ArrayList<>();

    public UserService() {
        loadUsers();
    }

    private void loadUsers() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(JSON_FILE);
            if (file.exists()) {
                users = mapper.readValue(file, new TypeReference<List<User>>() {});
            }
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to load users from JSON file.", e);
        }
    }

    private void saveUsers() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(JSON_FILE), users);
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to save users to JSON file.", e);
        }
    }

    public void createUser(User user) {
        if (users.stream().anyMatch(u -> u.getEmail().equals(user.getEmail()))) {
            throw new IllegalArgumentException("A user with this email already exists.");
        }
        user.setId(UUID.randomUUID().toString());
        users.add(user);
        saveUsers();
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public User getUserById(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found."));
    }

    public User getUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
    }

    public User updateUser(String id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        saveUsers();
        return existingUser;
    }

    public void deleteUser(String id) {
        User userToDelete = getUserById(id);
        users.remove(userToDelete);
        saveUsers();
    }
}
