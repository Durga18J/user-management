package com.example.usermanagement.service.impl;

import com.example.usermanagement.entity.CityEntity;
import com.example.usermanagement.entity.StateEntity;
import com.example.usermanagement.repository.CityRepository;
import com.example.usermanagement.repository.StateRepository;
import com.example.usermanagement.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final StateRepository stateRepository;
    private final CityRepository cityRepository;

    @Override
    public List<StateEntity> getAllStates() {
        return stateRepository.findAll();
    }

    @Override
    public List<CityEntity> getCitiesByState(Long stateId) {
        return cityRepository.findByStateEntityId(stateId);
    }
}
