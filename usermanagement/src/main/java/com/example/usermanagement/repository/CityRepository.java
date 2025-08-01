package com.example.usermanagement.repository;

import com.example.usermanagement.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
    List<CityEntity> findByStateEntityId(Long stateId);
}
