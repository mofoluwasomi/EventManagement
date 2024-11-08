package com.eventmanagement.event_management_app.dto;

import com.eventmanagement.event_management_app.model.UserRole;
import lombok.Data;
import lombok.NonNull;

@Data
public class UserDto {

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String userEmail;
    @NonNull
    private String userPassword;
    @NonNull
    private String company;



}
