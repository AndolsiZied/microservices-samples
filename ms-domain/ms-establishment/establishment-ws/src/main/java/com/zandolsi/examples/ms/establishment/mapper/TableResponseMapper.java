package com.zandolsi.examples.ms.establishment.mapper;

import com.zandolsi.examples.ms.establishment.dto.response.TableResponseDto;
import com.zandolsi.examples.ms.establishment.model.Table;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TableResponseMapper extends GenericMapper<Table, TableResponseDto> {
}
