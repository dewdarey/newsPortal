package kz.springproject.phoenix.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {

    private String username;
    private String password;
    private String confirmPassword;
    private String fullName;
    private String avatarUrl;

}
