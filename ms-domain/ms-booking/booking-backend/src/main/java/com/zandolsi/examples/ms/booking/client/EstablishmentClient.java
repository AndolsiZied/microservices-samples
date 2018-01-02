package com.zandolsi.examples.ms.booking.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.PATCH;

@FeignClient("establishment-services")
public interface EstablishmentClient {

    @RequestMapping(method = PATCH, consumes = "application/json", value = "/api/establishments/{establishmentId}")
    void patchEstablishment(@PathVariable("establishmentId") String establishmentId, @RequestBody JsonNode body);

}
