package com.eventmanagement.event_management_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;


@Data // Lombok annotation to generate getters, setters, toString, etc.
@Document(collection = "Users") // This maps to the MongoDB collection
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String userEmail;
    private String userPassword;
    private UserRole userRole;
    private String company;




//    // You may want to store roles or authorities in the database
//    private List<GrantedAuthority> authorities = new ArrayList<>();
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities; // Return stored authorities
//    }
//
//    @Override
//    public String getPassword() {
//        return userPassword; // Return the actual password
//    }
//
//    @Override
//    public String getUsername() {
//        return userEmail; // Use email as the username
//    }
//
//    // These can be modified based on your requirements
//    @Override
//    public boolean isAccountNonExpired() {
//        return true; // For simplicity, assume the account is never expired
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true; // Assume the account is never locked
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true; // Assume the credentials are always valid
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true; // Set based on your application’s needs
//    }


}
