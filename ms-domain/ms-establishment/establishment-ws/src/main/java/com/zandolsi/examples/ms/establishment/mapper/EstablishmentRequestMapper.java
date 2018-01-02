package com.zandolsi.examples.ms.establishment.mapper;

import com.zandolsi.examples.ms.establishment.dto.request.EstablishmentRequestDto;
import com.zandolsi.examples.ms.establishment.model.Establishment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TableRequestMapper.class})
public interface EstablishmentRequestMapper extends GenericMapper<EstablishmentRequestDto, Establishment> {
}
