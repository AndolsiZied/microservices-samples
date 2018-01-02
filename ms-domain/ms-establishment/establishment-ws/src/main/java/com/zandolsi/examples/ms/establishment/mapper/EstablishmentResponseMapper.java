package com.zandolsi.examples.ms.establishment.mapper;

import com.zandolsi.examples.ms.establishment.dto.response.EstablishmentResponseDto;
import com.zandolsi.examples.ms.establishment.model.Establishment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TableResponseMapper.class})
public interface EstablishmentResponseMapper extends GenericMapper<Establishment, EstablishmentResponseDto> {
}
