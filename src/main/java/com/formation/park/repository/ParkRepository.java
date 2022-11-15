package com.formation.park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.park.model.Park;
import java.util.Optional;

@Repository
public interface ParkRepository extends JpaRepository<Park, Integer> {
  Optional<Park> findByRecordId(String recordID);

}
