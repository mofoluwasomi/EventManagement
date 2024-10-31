package com.eventmanagement.event_management_app.users;

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
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        try {
            User user = userService.loginUser(email, password);
            return new ResponseEntity<>("Login successful! Welcome " + user.getFirstName() + "!", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid email or password.", HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/profile/{id}")
    public ResponseEntity<User> getUserProfile(@PathVariable String id){
        User user = userService.userProfile(id);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/profile/{id}")
    public ResponseEntity<User> updateUserProfile(@PathVariable String id, @RequestBody User updatedUser) {
        User user = userService.updateUserProfile(id, updatedUser);
        return ResponseEntity.ok(user);
    }


}
