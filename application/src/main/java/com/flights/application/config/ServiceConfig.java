package com.flights.application.config;

import com.flights.domain.ports.driven.ServiceRepositoryPort;
import com.flights.domain.ports.driving.ServiceAdapter;
import com.flights.domain.ports.driving.impl.ServiceAdapterImpl;
import com.flights.output.external.ExternalAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ServiceRepositoryPort serviceRepositoryPort(){
        return new ExternalAdapter();
    }

    @Bean
public ServiceAdapter serviceAdapter(ServiceRepositoryPort serviceRepositoryPort){
        return new ServiceAdapterImpl(serviceRepositoryPort);
    }
}
