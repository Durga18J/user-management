package com.example.usermanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    private Long id;
    private String name;
    private String gender;
    private String email;
    private String state;
    private String city;
    private String hobbies;
    private String photoPath;
}
