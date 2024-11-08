package com.eventmanagement.event_management_app.service;

import com.eventmanagement.event_management_app.dto.UserDto;
import com.eventmanagement.event_management_app.dto.UserLoginDto;
import com.eventmanagement.event_management_app.dto.UserUpdateDto;
import com.eventmanagement.event_management_app.model.User;
import com.eventmanagement.event_management_app.model.UserRole;
import com.eventmanagement.event_management_app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User registerAttendee(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserPassword(userDto.getUserPassword());
        user.setUserRole(UserRole.ATTENDEE);
        user.setCompany(userDto.getCompany());
        return userRepository.save(user);

    }
    public User registerAdmin(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserPassword(userDto.getUserPassword());
        user.setUserRole(UserRole.ORGANIZER);
        user.setCompany(userDto.getCompany());
        return userRepository.save(user);
    }


//    public User registerUser(User user) {
//        // Check if user with the same email already exists
//        Optional<User> existingUser = Optional.ofNullable(userRepository.findByUserEmail(user.getUserEmail()));
//        if (existingUser.isPresent()) {
//            throw new IllegalArgumentException("User with email " + user.getUserEmail() + " already exists.");
//        }
//
//        // Save the new user to the database
//        return userRepository.save(user);
//    }

    public User loginUser(UserLoginDto userLoginDto) {
        User user = userRepository.findByUserEmail(userLoginDto.getUserEmail());

        // Check if user exists and if the password matches
        if (user == null || !userLoginDto.getUserPassword().equals(user.getUserPassword())) {
            throw new IllegalArgumentException("Invalid email or password.");
        }

        return user;
    }
    public User userProfile(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found."));
    }
    public User updateUserProfile(String id, UserUpdateDto userUpdateDto) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found."));


        if (userUpdateDto.getFirstName() != null) {
            existingUser.setFirstName(userUpdateDto.getFirstName());
        }
        if (userUpdateDto.getLastName() != null) {
            existingUser.setLastName(userUpdateDto.getLastName());
        }
        if (userUpdateDto.getUserEmail() != null) {
            existingUser.setUserEmail(userUpdateDto.getUserEmail());
        }
        if (userUpdateDto.getCompany() != null) {
            existingUser.setCompany(userUpdateDto.getCompany());
        }

        // Save the updated user
        return userRepository.save(existingUser);
    }




}

