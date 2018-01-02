package com.zandolsi.examples.ms.establishment.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.ExtendedJsonPatchFactory;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchFactory;
import com.github.fge.jsonpatch.operation.JsonPatchOperation;
import com.google.common.collect.Lists;
import com.zandolsi.examples.ms.establishment.configuration.WebConfiguration;
import com.zandolsi.examples.ms.establishment.dto.request.EstablishmentRequestDto;
import com.zandolsi.examples.ms.establishment.dto.request.TableRequestDto;
import com.zandolsi.examples.ms.establishment.dto.response.EstablishmentResponseDto;
import com.zandolsi.examples.ms.establishment.mapper.EstablishmentRequestMapper;
import com.zandolsi.examples.ms.establishment.mapper.EstablishmentResponseMapper;
import com.zandolsi.examples.ms.establishment.model.Establishment;
import com.zandolsi.examples.ms.establishment.service.EstablishmentService;
import com.zandolsi.examples.ms.establishment.util.Patch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toMap;
import static org.springframework.web.bind.annotation.RequestMethod.*;

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

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<EstablishmentResponseDto> get(@PathVariable String id) {
        EstablishmentResponseDto establishment = establishmentResponseMapper.to(establishmentService.get(id));
        if (nonNull(establishment)) {
            return ResponseEntity.ok(establishment);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(method = POST, consumes = "application/json")
    public ResponseEntity<EstablishmentResponseDto> save(@RequestBody EstablishmentRequestDto establishment) throws URISyntaxException {
        Establishment createdEstablishment = establishmentService.save(establishmentRequestMapper.to(establishment));
        URI newResourceURI = new URI("/api/establishments/" + createdEstablishment.getId());
        return ResponseEntity.created(newResourceURI).body(establishmentResponseMapper.to(createdEstablishment));
    }

    @RequestMapping(value = "/{id}", method = PATCH, consumes = "application/json")
    public ResponseEntity<Void> patch(@PathVariable("id") String id, @RequestBody JsonNode establishmentPatch) throws IOException {
        EstablishmentRequestDto existingEstablishment = establishmentRequestMapper.from(establishmentService.get(id));
        if (nonNull(existingEstablishment)) {
            EstablishmentRequestDto patchedEstablishment = getPatchedEstablishmentRequestDto(establishmentPatch, existingEstablishment);
            Establishment establishmentToUpdate = establishmentRequestMapper.to(patchedEstablishment);
            establishmentToUpdate.setId(id);
            establishmentService.save(establishmentToUpdate);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping("/message")
    public String message() {
        return webConfiguration.message();
    }

    private EstablishmentRequestDto getPatchedEstablishmentRequestDto(JsonNode establishmentPatchNode,
                                                                      EstablishmentRequestDto existingEstablishment) throws IOException {
        List<JsonPatchOperation> tablesOps = Lists.newArrayList();
        List<JsonPatchOperation> otherOps = Lists.newArrayList();
        JsonPatch establishmentPatch = ExtendedJsonPatchFactory.create().fromJson(establishmentPatchNode);
        Map<Boolean, List<JsonPatchOperation>> partitions = establishmentPatch.getOperations().stream().collect
                (partitioningBy(o -> o.getPath().toString().contains("tables")));
        tablesOps.addAll(partitions.get(true));
        otherOps.addAll(partitions.get(false));
        EstablishmentRequestDto patchedEstablishment = Patch.of(EstablishmentRequestDto.class).patch
                (existingEstablishment, new JsonPatch(otherOps));
        Map<String, TableRequestDto> tableByCode = patchedEstablishment.getTables().stream().collect(
                toMap(t -> t.getCode(), identity()));
        tablesOps.stream().forEach(operation -> {
            String[] paths = operation.getPath().toString().split("/");
            TableRequestDto tableRequestDto = tableByCode.get(paths[2]);
            String[] fields = operation.toString().split("\"");
            switch (operation.getOp()) {
                case "add":
                    tableRequestDto.getBookings().add(fields[fields.length - 1]);
                    break;
            }
        });
        return patchedEstablishment;
    }
}
