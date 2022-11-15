package com.formation.velo.service.impl;

import com.formation.velo.api.OpenDataNantesClient;
import com.formation.velo.api.OpenDataVeloNantes;
import com.formation.velo.model.Station;
import com.formation.velo.repository.StationRepository;
import com.formation.velo.service.StationService;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository repository) {
        this.stationRepository = repository;
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }

    @Override
    public Optional<Station> findById(Integer id) {
        return stationRepository.findById(id);
    }

    @Override
    public Station save(Station station) {
        return stationRepository.save(station);
    }

    @Override
    public void deleteById(Integer id) {
        stationRepository.deleteById(id);
    }

    @Override
    public void delete(Station station) {
        stationRepository.delete(station);
    }

    @Override
    public void getRecords() {
        // appel openData
        String baseUrl = "https://data.nantesmetropole.fr/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenDataNantesClient client = retrofit.create(OpenDataNantesClient.class);
        Call<OpenDataVeloNantes> openDataVeloNantesCall = client.getRecords();
        try {
            OpenDataVeloNantes openDataVeloNantes = openDataVeloNantesCall.execute().body();
            System.out.printf(openDataVeloNantes.toString());
            // Save records dans station

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Station> findByRecordId(Integer id) {
        return Optional.empty();
    }
}
