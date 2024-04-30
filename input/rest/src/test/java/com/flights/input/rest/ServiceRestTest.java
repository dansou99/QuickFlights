package com.flights.input.rest;

import com.flights.domain.ports.driving.AirportAdapter;
import com.flights.domain.ports.driving.ServiceAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@Nested
class ServiceRestTest {

    private final String DEFAULT_NAME = "DAN";

    @Mock
    private ServiceAdapter serviceAdapter;

    @Mock
    private AirportAdapter airportAdapter;

    private ServiceRest serviceRest;

    @BeforeEach
    void setUp() {
        openMocks(this);
        serviceRest = new ServiceRest(serviceAdapter,airportAdapter);
    }

    @Test
    void testGetSayHello() {
        when(serviceAdapter.getHelloName(DEFAULT_NAME)).thenReturn("Hello DAN");
        var actual = serviceRest.getSayHello(DEFAULT_NAME);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertEquals("Hello DAN", actual.getBody());
    }
}
