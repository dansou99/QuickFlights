package com.template.domain.ports.driving.impl;

import com.template.domain.ports.driven.ServiceRepositoryPort;
import com.template.domain.ports.driving.ServiceAdapter;

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
