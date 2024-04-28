package com.flights.domain.ports.driving.impl;

import com.flights.domain.ports.driving.ServiceAdapter;
import com.flights.domain.ports.driven.ServiceRepositoryPort;

public class ServiceAdapterImpl implements ServiceAdapter {

    private final ServiceRepositoryPort serviceRepositoryPort;

    public ServiceAdapterImpl(ServiceRepositoryPort serviceRepositoryPort) {
        this.serviceRepositoryPort = serviceRepositoryPort;
    }

    @Override
    public String getHelloName(String name) {
        return serviceRepositoryPort.getHelloName(name);
    }
}
