package com.udea.vuelos2024.service;

import com.udea.vuelos2024.dao.IFlightDAO;
import com.udea.vuelos2024.exception.FlightNotFoundException;
import com.udea.vuelos2024.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private IFlightDAO flightDAO;

    public Flight saveFlight(Flight flight) {
        return flightDAO.save(flight);
    }

    public String deleteFlight(Long id) {
        flightDAO.deleteById(id);
        return "Flight Deleted";
    }

    public Iterable<Flight> getAllFlights() {
        return flightDAO.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightDAO.findById(id);
    }

    public Flight updateFlight(Flight flight) {
        Flight existingFlight = flightDAO.findById(flight.getIdFlight()).orElse(null);
        existingFlight.setNombreAvion(flight.getNombreAvion());
        existingFlight.setNumeroVuelo(flight.getNumeroVuelo());
        existingFlight.setOrigen(flight.getOrigen());
        existingFlight.setDestino(flight.getDestino());
        existingFlight.setRating(flight.getRating());
        existingFlight.setCapacidad(flight.getCapacidad());
        existingFlight.setPlanVuelo(flight.getPlanVuelo());
        existingFlight.setCumplido(flight.getCumplido());
        return flightDAO.save(existingFlight);
    }

    public List<Flight> viewBestFlights() throws FlightNotFoundException {
        List<Flight> bestFlights = flightDAO.viewBestFlights();
        if (bestFlights.isEmpty()) {
            throw new FlightNotFoundException("No flights found with rating greater or equal than 4");
        }
        return bestFlights;
    }

}
