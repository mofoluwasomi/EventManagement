package com.eventmanagement.event_management_app.controller;

import com.eventmanagement.event_management_app.dto.UserDto;
import com.eventmanagement.event_management_app.dto.UserLoginDto;
import com.eventmanagement.event_management_app.dto.UserUpdateDto;
import com.eventmanagement.event_management_app.model.User;
import com.eventmanagement.event_management_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserService userService;

    // Endpoint to register a new user
    @PostMapping("/register/Attendee")
    public ResponseEntity<String> registerAttendee( @RequestBody UserDto userDto) {
        try {
            userService.registerAttendee(userDto);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/register/Admin")
    public ResponseEntity<String> registerAdmin(@RequestBody UserDto userDto) {
        try {
            userService.registerAdmin(userDto);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDto userLoginDto) {
        try {
            User user = userService.loginUser(userLoginDto);
            return new ResponseEntity<>("Login successful! Welcome " + user.getFirstName() + "!", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid email or password.", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/user/profile/{id}")
    public ResponseEntity<User> getUserProfile(@PathVariable String id){
        User user = userService.userProfile(id);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/user/profile/{id}")
    public ResponseEntity<User> updateUserProfile(@PathVariable String id, @RequestBody UserUpdateDto userUpdateDto) {
        User user = userService.updateUserProfile(id, userUpdateDto);
        return ResponseEntity.ok(user);
    }


}
