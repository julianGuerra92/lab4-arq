package com.udea.vuelos2024.dao;

import com.udea.vuelos2024.model.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlightDAO extends CrudRepository<Flight, Long> {

    @Query("FROM Flight f WHERE f.rating >= 4 AND f.cumplido = true")
    public List<Flight> viewBestFlights();

}
