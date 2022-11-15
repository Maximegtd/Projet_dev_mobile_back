package com.formation.velo.controllers;

import com.formation.velo.model.Station;
import com.formation.velo.service.StationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("stations")
    public ResponseEntity<List<Station>> getAll() {
        List<Station> stations = stationService.findAll();

        return ResponseEntity.ok(stations);
    }

    @GetMapping("stations/{id}")
    public ResponseEntity<Optional<Station>> getStationById(@PathVariable Integer id) {
        Optional<Station> station = stationService.findById(id);

        return ResponseEntity.ok(station);
    }

    @PostMapping("stations/add")
    public ResponseEntity<Station> add(@RequestParam String name) {

        Station station = stationService.save(Station.builder().name(name).build());
        return ResponseEntity.ok(station);
    }

    @DeleteMapping("stations/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        stationService.deleteById(id);
        return ResponseEntity.ok("deleted");
    }

    @PostMapping("stations/update")
    public ResponseEntity<String> update(@RequestBody Station station) {
        stationService.save(station);
        return ResponseEntity.ok("updated");
    }
}
