package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.hrmanager.hrPlatform.model.User;


@Mapper(componentModel = "spring")
public interface UserMapper {

        UserDto toDto(User user);

        User toEntity(UserDto dto);

}
