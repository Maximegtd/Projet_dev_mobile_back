package com.formation.park.service.impl;

import com.formation.park.model.Park;
import com.formation.park.api.OpenDataNantesClient;
import com.formation.park.api.OpenDataParkNantes;
import com.formation.park.repository.ParkRepository;
import com.formation.park.service.ParkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.io.IOException;
import java.util.Arrays;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.Call;

@Service

public class ParkServiceImpl implements ParkService {

  private final ParkRepository parkRepository;

  public ParkServiceImpl(ParkRepository repository) {
    this.parkRepository = repository;
  }

  @Override
  public List<Park> findAll() {
    return parkRepository.findAll();
  }

  @Override
  public Optional<Park> findById(Integer id) {
    return parkRepository.findById(id);
  }

  @Override
  public Park save(Park park) {
    return parkRepository.save(park);
  }

  @Override
  public void deleteById(Integer id) {
    parkRepository.deleteById(id);
  }

  @Override
  public void delete(Park park) {
    parkRepository.delete(park);
  }

  @Override
  public void getRecords() {
    // appel api
    String baseUrl = "https://data.nantesmetropole.fr/";

    Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
        .build();

    OpenDataNantesClient client = retrofit.create(OpenDataNantesClient.class);

    Call<OpenDataParkNantes> openDataVeloNantesCall = client.getRecords();

    try {

      OpenDataParkNantes openDataParkNantes = openDataVeloNantesCall.execute().body();
      System.out.printf(openDataParkNantes.toString());

      // Save records dans park

      Arrays.stream(openDataParkNantes.getRecords()).forEach(record -> {
        Optional<Park> parkToUpdate = findByRecordId(record.getRecordId());
        if (parkToUpdate.isPresent()) {
          parkToUpdate.get()
              .setGrp_disponible(record.getField().getGrpDisponible());
          parkToUpdate.get()
              .setGrp_identifiant(record.getField().getGrpIdentifiant());
          parkToUpdate.get()
              .setGrp_nom(record.getField().getGrpNom());
          save(parkToUpdate.get());
        } else {
          // on crée la park
          Park newPark = Park.builder()
              .recordId(record.getRecordId())
              .grp_disponible(record.getField().getGrpDisponible())
              .grp_identifiant(record.getField().getGrpIdentifiant())
              .grp_nom(record.getField().getGrpNom())
              .lattitude(record.getField().getLocation()[0])
              .longitude(record.getField().getLocation()[1])
              .build();
          // on save
          save(newPark);
        }
      });
    } catch (IOException e) {

      throw new RuntimeException(e);

    }

  }

  @Override
  public Optional<Park> findByRecordId(String recordId) {
    return parkRepository.findByRecordId(recordId);
  }

}
