package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.RoleDto;
import org.mapstruct.Mapper;

import javax.management.relation.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto toDto(Role r);
    Role toEntity(RoleDto dto);
}
