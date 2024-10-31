package com.eventmanagement.event_management_app.users;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        // Check if user with the same email already exists
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByUserEmail(user.getUserEmail()));
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User with email " + user.getUserEmail() + " already exists.");
        }

        // Save the new user to the database
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByUserEmail(email);

        // Check if user exists and if the password matches
        if (user == null || !password.equals(user.getUserPassword())) {
            throw new IllegalArgumentException("Invalid email or password.");
        }

        return user;
    }
    public User userProfile(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found."));
    }
    public User updateUserProfile(String id, User updatedUser) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found."));

        // Update fields if they are not null in the updatedUser object
        if (updatedUser.getUserPassword() != null) {
            existingUser.setUserPassword(updatedUser.getUserPassword());
        }
        if (updatedUser.getFirstName() != null) {
            existingUser.setFirstName(updatedUser.getFirstName());
        }
        if (updatedUser.getLastName() != null) {
            existingUser.setLastName(updatedUser.getLastName());
        }

        // Save the updated user
        return userRepository.save(existingUser);
    }



}

