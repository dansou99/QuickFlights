package com.template.output.external;

import com.template.domain.ports.driven.ServiceRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExternalAdapter implements ServiceRepositoryPort {

    private final Logger LOG = LoggerFactory.getLogger(ExternalAdapter.class);

    public ExternalAdapter(){

    }


    @Override
    public String getHelloName(String name) {
        return "Hello " + name;
    }
}
