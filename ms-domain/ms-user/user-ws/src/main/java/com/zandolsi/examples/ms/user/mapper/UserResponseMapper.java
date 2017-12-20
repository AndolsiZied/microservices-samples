package com.zandolsi.examples.ms.user.mapper;

import com.zandolsi.examples.ms.user.dto.response.UserResponseDto;
import com.zandolsi.examples.ms.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper extends GenericMapper<User, UserResponseDto> {
}
