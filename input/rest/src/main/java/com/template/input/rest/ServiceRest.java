package com.template.input.rest;

import com.template.domain.ports.driving.ServiceAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceRest {

    private final ServiceAdapter serviceAdapter;

    public ServiceRest(ServiceAdapter serviceAdapter) {
        this.serviceAdapter = serviceAdapter;
    }

    private final Logger LOG = LoggerFactory.getLogger(ServiceRest.class);

    @GetMapping("/sayHello/{name}")
    public ResponseEntity<String> getSayHello(
            @PathVariable("name") String name) {
        LOG.info("operation=getSayHello={}, message='Saying Hello!'", name);
        String response = serviceAdapter.getHelloName(name);
        return ResponseEntity.ok(response);
    }


}
