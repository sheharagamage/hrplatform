package com.hrmanager.hrPlatform.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer userId;
    private String email;
    private Boolean isAdmin;
    private Integer employeeId;
    private Set<Integer> roleIds;
}