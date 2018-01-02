package com.zandolsi.examples.ms.establishment.mapper;

import com.zandolsi.examples.ms.establishment.dto.request.TableRequestDto;
import com.zandolsi.examples.ms.establishment.model.Table;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TableRequestMapper extends GenericMapper<TableRequestDto, Table> {
}
