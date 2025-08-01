package com.example.usermanagement.controller;

import com.example.usermanagement.entity.CityEntity;
import com.example.usermanagement.entity.StateEntity;
import com.example.usermanagement.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
@CrossOrigin
public class LocationController {

    private final LocationService locationService;

    // API to get all states
    @GetMapping("/states")
    public List<StateEntity> getStates() {
        return locationService.getAllStates();
    }

    // API to get all cities for a specific stateEntity
    @GetMapping("/cities/{stateId}")
    public List<CityEntity> getCities(@PathVariable Long stateId) {
        return locationService.getCitiesByState(stateId);
    }
}
