package com.example.usermanagement.controller;

import com.example.usermanagement.dto.UserRequestDto;
import com.example.usermanagement.dto.UserResponseDto;
import com.example.usermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponseDto registerUser(@RequestParam("name") String name,
                                        @RequestParam("gender") String gender,
                                        @RequestParam("dateOfBirth") String dob,
                                        @RequestParam("mobile") String mobile,
                                        @RequestParam("email") String email,
                                        @RequestParam("stateId") Long stateId,
                                        @RequestParam("cityId") Long cityId,
                                        @RequestParam("hobbies") String hobbies,
                                        @RequestParam("photo") MultipartFile photo) throws IOException {

        UserRequestDto dto = new UserRequestDto();
        dto.setName(name);
        dto.setGender(gender);
        dto.setDateOfBirth(dob);
        dto.setMobile(mobile);
        dto.setEmail(email);
        dto.setStateId(stateId);
        dto.setCityId(cityId);
        dto.setHobbies(hobbies);

        return userService.registerUserWithPhoto(dto, photo);
    }

    @GetMapping
    public List<UserResponseDto> getUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String state) {

        // ✅ Convert empty strings to null so that all users show when no filters are applied
        if (name != null && name.isBlank()) name = null;
        if (gender != null && gender.isBlank()) gender = null;
        if (state != null && state.isBlank()) state = null;

        return userService.getAllUsers(name, gender, state);
    }
}
