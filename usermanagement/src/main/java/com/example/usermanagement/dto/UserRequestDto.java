package com.example.usermanagement.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String gender;
    private String dateOfBirth; // dd/MM/yyyy
    private String mobile;
    private String email;
    private Long stateId;
    private Long cityId;
    private String hobbies;
}
