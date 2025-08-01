package com.example.usermanagement.service;

import com.example.usermanagement.dto.UserRequestDto;
import com.example.usermanagement.dto.UserResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    UserResponseDto registerUser(UserRequestDto dto);

    List<UserResponseDto> getAllUsers(String name, String gender, String state);

    // ✅ New method for file upload
    UserResponseDto registerUserWithPhoto(UserRequestDto dto, MultipartFile photo) throws IOException;
}
