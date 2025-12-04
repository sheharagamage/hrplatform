package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserDto dto);
    UserDto update(Integer id, UserDto dto);
    UserDto findById(Integer id);
    List<UserDto> findAll();
    void delete(Integer id);
}
