package com.flights.domain.ports.driven;

import com.flights.domain.core.Airport;

import java.util.List;

public interface AirportProviderPort {

    List<Airport> getAllAirports();
}
