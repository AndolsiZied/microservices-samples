package com.zandolsi.examples.ms.booking.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class EstablishmentClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(EstablishmentClient.class);

    @Autowired
    private RestTemplate restTemplate;

    public void patchEstablishment(String establishmentId, String body) {
        String serviceUri = String.format("http://establishment-services/api/establishments/%s", establishmentId);
        LOGGER.debug("Calling establishment service [{}]...", serviceUri);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);

        HttpEntity entity = new HttpEntity<>(body, headers);

        ResponseEntity<Void> restExchange =
                restTemplate.exchange(
                        serviceUri,
                        HttpMethod.PATCH,
                        entity, Void.class);
        if (!restExchange.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
            LOGGER.error("Unexpected response  : " + restExchange.getBody());
            throw new RuntimeException("Unexpected response was received : " + restExchange.getBody());
        }
    }
}
