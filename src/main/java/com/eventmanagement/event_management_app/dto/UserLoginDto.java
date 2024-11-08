package com.eventmanagement.event_management_app.dto;

import lombok.Data;
import lombok.NonNull;
@Data
public class UserLoginDto {
    @NonNull
    private String userEmail;
    @NonNull
    private String userPassword;
}
