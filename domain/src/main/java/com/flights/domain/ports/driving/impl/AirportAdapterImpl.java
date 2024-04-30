package com.flights.domain.ports.driving.impl;

import com.flights.domain.core.Airport;
import com.flights.domain.ports.driven.AirportProviderPort;
import com.flights.domain.ports.driving.AirportAdapter;

import java.util.List;

public class AirportAdapterImpl implements AirportAdapter {

    private final AirportProviderPort airportProviderPort;

    public AirportAdapterImpl(AirportProviderPort airportProviderPort) {
        this.airportProviderPort = airportProviderPort;
    }

    @Override
    public List<Airport> getAllAirports() {

        return airportProviderPort.getAllAirports();
    }

}
