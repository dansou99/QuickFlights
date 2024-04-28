package com.template.application.config;

import com.template.domain.ports.driven.ServiceRepositoryPort;
import com.template.domain.ports.driving.ServiceAdapter;
import com.template.domain.ports.driving.impl.ServiceAdapterImpl;
import com.template.output.external.ExternalAdapter;
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
