package com.udea.vuelos2024.controller;

import com.udea.vuelos2024.exception.InvalidRating;
import com.udea.vuelos2024.exception.ModelNotFoundException;
import com.udea.vuelos2024.model.Flight;
import com.udea.vuelos2024.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
@CrossOrigin("*")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/save")
    public long saveFlight(@RequestBody Flight flight) throws InvalidRating {
        if (flight.getRating() < 0 || flight.getRating() > 5) {
            throw new InvalidRating("Rating must be between 0 and 5");
        }
        flightService.saveFlight(flight);
        return flight.getIdFlight();
    }

    @GetMapping("/getAll")
    public Iterable<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/list/{id}")
    public Flight getFlightById(@PathVariable("id") long id) {
        Optional<Flight> flight = flightService.getFlightById(id);
        if (flight.isPresent()) {
            return flight.get();
        }
        throw new ModelNotFoundException("Flight not found with id " + id);
    }

    @GetMapping("/topFlights")
    public ResponseEntity<List<Flight>> viewBestFlights() {
        List<Flight> bestFlights = flightService.viewBestFlights();
        return new ResponseEntity<List<Flight>>(bestFlights, HttpStatus.ACCEPTED);
    }

    @PutMapping()
    public Flight updateFlight(@RequestBody Flight flight) {
        return flightService.updateFlight(flight);
    }

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable("id") long id) {
        return flightService.deleteFlight(id);
    }

}
