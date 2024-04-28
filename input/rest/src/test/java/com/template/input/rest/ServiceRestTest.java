package com.template.input.rest;

import com.template.domain.ports.driving.ServiceAdapter;
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

    private ServiceRest serviceRest;

    @BeforeEach
    void setUp() {
        openMocks(this);
        serviceRest = new ServiceRest(serviceAdapter);
    }

    @Test
    void testGetSayHello() {
        when(serviceAdapter.getHelloName(DEFAULT_NAME)).thenReturn("Hello DAN");
        var actual = serviceRest.getSayHello(DEFAULT_NAME);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertEquals("Hello DAN", actual.getBody());
    }
}
