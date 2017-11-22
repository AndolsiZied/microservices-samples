package com.zandolsi.examples.ms.establishment.controller;

import com.zandolsi.examples.ms.establishment.configuration.WebConfiguration;
import com.zandolsi.examples.ms.establishment.dto.request.EstablishmentRequestDto;
import com.zandolsi.examples.ms.establishment.dto.response.EstablishmentResponseDto;
import com.zandolsi.examples.ms.establishment.mapper.EstablishmentRequestMapper;
import com.zandolsi.examples.ms.establishment.mapper.EstablishmentResponseMapper;
import com.zandolsi.examples.ms.establishment.model.Establishment;
import com.zandolsi.examples.ms.establishment.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/establishments")
public class EstablishmentController {

    @Autowired
    private EstablishmentService establishmentService;
    @Autowired
    private EstablishmentResponseMapper establishmentResponseMapper;
    @Autowired
    private EstablishmentRequestMapper establishmentRequestMapper;
    @Autowired
    private WebConfiguration webConfiguration;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EstablishmentResponseDto> get(@PathVariable String id) {
        Optional<EstablishmentResponseDto> establishment = Optional.ofNullable(establishmentResponseMapper.to(establishmentService
                .get(id)));
        if (establishment.isPresent()) {
            return ResponseEntity.ok(establishment.get());
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<EstablishmentResponseDto> save(@RequestBody EstablishmentRequestDto establishment) throws URISyntaxException {
        Establishment createdEstablishment = establishmentService.save(establishmentRequestMapper.to(establishment));
        URI newResourceURI = new URI("/api/establishments" + createdEstablishment.getId());
        return ResponseEntity.created(newResourceURI).body(establishmentResponseMapper.to(createdEstablishment));
    }

    @RequestMapping("/message")
    public String message() {
        return webConfiguration.message();
    }
}
