package com.formation.park.service;

import com.formation.park.model.Park;

import java.util.List;
import java.util.Optional;

public interface ParkService {

  List<Park> findAll();

  Optional<Park> findById(Integer id);

  Park save(Park park);

  void deleteById(Integer id);

  void delete(Park park);

  void getRecords();

  Optional<Park> findByRecordId(String recordId);
}