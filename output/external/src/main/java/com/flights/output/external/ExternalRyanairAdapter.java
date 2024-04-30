package com.flights.output.external;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.flights.domain.core.Airport;
import com.flights.domain.ports.driven.AirportProviderPort;
import com.flights.output.external.entity.AirportRyanair;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class ExternalRyanairAdapter implements AirportProviderPort {

    private static final String url = "https://www.ryanair.com/api";
    private final RestTemplate restTemplate;

    public ExternalRyanairAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Airport> getAllAirports() {

        try {

            // Make GET call
            ResponseEntity<AirportRyanair[]> response = restTemplate.exchange(
                    url + "/views/locate/5/airports/en/active", HttpMethod.GET, null, AirportRyanair[].class);

            final List<Airport> airportList = new ArrayList<>();

            for (AirportRyanair airportRyanair : Objects.requireNonNull(response.getBody())) {
                airportList.add(mapToAirport(airportRyanair));
            }
            return airportList;
        } catch (Exception e) {
            log.error("Something went wrong with Ryanair API");
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling endpoint for Ryanair",
                    e
            );
        }
    }

    private Airport mapToAirport(AirportRyanair airportRyanair) {
        Airport airport = new Airport();
        airport.setCode(airportRyanair.getCode());
        airport.setName(airportRyanair.getName());
        return airport;
    }

}
