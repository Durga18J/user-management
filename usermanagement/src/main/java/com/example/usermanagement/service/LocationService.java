package com.example.usermanagement.service;

import com.example.usermanagement.entity.CityEntity;
import com.example.usermanagement.entity.StateEntity;
import java.util.List;

public interface LocationService {

    // Fetch all states
    List<StateEntity> getAllStates();

    // Fetch all cities for a given state
    List<CityEntity> getCitiesByState(Long stateId);
}
