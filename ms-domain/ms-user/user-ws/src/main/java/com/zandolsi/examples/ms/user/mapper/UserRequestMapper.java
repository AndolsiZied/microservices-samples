package com.zandolsi.examples.ms.user.mapper;

import com.zandolsi.examples.ms.user.dto.request.UserRequestDto;
import com.zandolsi.examples.ms.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestMapper extends GenericMapper<UserRequestDto, User> {
}
