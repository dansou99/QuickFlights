package com.flights.input.rest;

import com.flights.domain.core.Airport;
import com.flights.domain.ports.driving.AirportAdapter;
import com.flights.domain.ports.driving.ServiceAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
public class ServiceRest {

    private final ServiceAdapter serviceAdapter;
    private final AirportAdapter airportAdapter;

    public ServiceRest(ServiceAdapter serviceAdapter, AirportAdapter airportAdapter) {
        this.serviceAdapter = serviceAdapter;
        this.airportAdapter = airportAdapter;
    }


    @GetMapping("/sayHello/{name}")
    public ResponseEntity<String> getSayHello(
            @PathVariable("name") String name) {
        log.info("operation=getSayHello={}, message='Saying Hello!'", name);
        String response = serviceAdapter.getHelloName(name);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllAirports")
    public ResponseEntity<List<?>> getAllAirports() {
        log.info("operation=getAllAirports, message='Fetching airports'");
        List<Airport> response = airportAdapter.getAllAirports();
        return ResponseEntity.ok(response);
    }


}
