package com.example.usermanagement.service.impl;

import com.example.usermanagement.dto.UserRequestDto;
import com.example.usermanagement.dto.UserResponseDto;
import com.example.usermanagement.entity.CityEntity;
import com.example.usermanagement.entity.StateEntity;
import com.example.usermanagement.entity.UserEntity;
import com.example.usermanagement.repository.CityRepository;
import com.example.usermanagement.repository.StateRepository;
import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;

    @Override
    public UserResponseDto registerUser(UserRequestDto dto) {
        throw new UnsupportedOperationException("Use registerUserWithPhoto() instead.");
    }

    @Override
    public UserResponseDto registerUserWithPhoto(UserRequestDto dto, MultipartFile photo) throws IOException {
        StateEntity state = stateRepository.findById(dto.getStateId())
                .orElseThrow(() -> new RuntimeException("State not found"));
        CityEntity city = cityRepository.findById(dto.getCityId())
                .orElseThrow(() -> new RuntimeException("City not found"));

        // Always create uploads folder inside project directory
        String uploadDir = System.getProperty("user.dir") + "/uploads/photos/";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        // Save file with unique name
        String fileName = System.currentTimeMillis() + "_" + photo.getOriginalFilename();
        File file = new File(uploadDir + fileName);
        photo.transferTo(file);

        // Save relative path for browser access
        String photoPath = "/uploads/photos/" + fileName;

        UserEntity user = UserEntity.builder()
                .name(dto.getName())
                .gender(dto.getGender())
                .dateOfBirth(LocalDate.parse(dto.getDateOfBirth(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .mobile(dto.getMobile())
                .email(dto.getEmail())
                .stateEntity(state)
                .cityEntity(city)
                .hobbies(dto.getHobbies())
                .photoPath(photoPath)
                .build();

        userRepository.save(user);
        return mapToResponse(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers(String name, String gender, String state) {
        // ✅ Trim and handle empty strings
        String finalName = (name != null && !name.trim().isEmpty()) ? name.trim() : null;
        String finalGender = (gender != null && !gender.trim().isEmpty()) ? gender.trim() : null;
        String finalState = (state != null && !state.trim().isEmpty()) ? state.trim() : null;

        return userRepository.findAll().stream()
                .filter(u -> finalName == null || u.getName().toLowerCase().contains(finalName.toLowerCase()))
                .filter(u -> finalGender == null || u.getGender().equalsIgnoreCase(finalGender))
                .filter(u -> finalState == null || u.getStateEntity().getName().equalsIgnoreCase(finalState))
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private UserResponseDto mapToResponse(UserEntity user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .gender(user.getGender())
                .email(user.getEmail())
                .state(user.getStateEntity().getName())
                .city(user.getCityEntity().getName())
                .hobbies(user.getHobbies())
                .photoPath(user.getPhotoPath())
                .build();
    }
}
