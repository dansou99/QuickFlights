package com.flights.application.config;

import com.flights.domain.ports.driven.AirportProviderPort;
import com.flights.domain.ports.driven.ServiceRepositoryPort;
import com.flights.domain.ports.driving.AirportAdapter;
import com.flights.domain.ports.driving.ServiceAdapter;
import com.flights.domain.ports.driving.impl.AirportAdapterImpl;
import com.flights.domain.ports.driving.impl.ServiceAdapterImpl;
import com.flights.output.external.ExternalAdapter;
import com.flights.output.external.ExternalRyanairAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceConfig {

    @Bean
    public ServiceRepositoryPort serviceRepositoryPort(){
        return new ExternalAdapter();
    }

    @Bean
    public AirportProviderPort airportProviderPort(RestTemplate restTemplate){
        return new ExternalRyanairAdapter(restTemplate);
    }

    @Bean
    public ServiceAdapter serviceAdapter(ServiceRepositoryPort serviceRepositoryPort){
        return new ServiceAdapterImpl(serviceRepositoryPort);
    }

    @Bean
    public AirportAdapter airportAdapter(AirportProviderPort airportProviderPort){
        return new AirportAdapterImpl(airportProviderPort);
    }
}
