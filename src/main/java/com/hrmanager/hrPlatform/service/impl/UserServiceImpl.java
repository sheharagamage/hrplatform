package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.UserDto;
import com.hrmanager.hrPlatform.mapper.UserMapper;
import com.hrmanager.hrPlatform.model.Employee;
import com.hrmanager.hrPlatform.model.Role;
import com.hrmanager.hrPlatform.model.User;
import com.hrmanager.hrPlatform.repository.EmployeeRepository;
import com.hrmanager.hrPlatform.repository.RoleRepository;
import com.hrmanager.hrPlatform.repository.UserRepository;
import com.hrmanager.hrPlatform.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final EmployeeRepository employeeRepo;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository userRepo, RoleRepository roleRepo,
                           EmployeeRepository employeeRepo, UserMapper mapper) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.employeeRepo = employeeRepo;
        this.mapper = mapper;
    }

    @Override
    public UserDto create(UserDto dto) {

        User u = new User();
        u.setEmail(dto.getEmail());
        u.setIsAdmin(dto.getIsAdmin());

        // Set employee
        if (dto.getEmployeeId() != null) {
            Employee e = employeeRepo.findById(dto.getEmployeeId())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            u.setEmployee(e);
        }

        // Set roles
        Set<Role> roles = new HashSet<>();
        if (dto.getRoleIds() != null) {
            for (Integer rId : dto.getRoleIds()) {
                Role r = roleRepo.findById(rId)
                        .orElseThrow(() -> new RuntimeException("Role not found"));
                roles.add(r);
            }
        }
        u.setRoles(roles);

        User saved = userRepo.save(u);

        // Convert to DTO with extra fields
        UserDto out = mapper.toDto(saved);
        out.setRoleIds(saved.getRoles().stream().map(Role::getRoleId).collect(Collectors.toSet()));
        if (saved.getEmployee() != null) {
            out.setEmployeeId(saved.getEmployee().getEmployeeId());
        }

        return out;
    }

    @Override
    public UserDto update(Integer id, UserDto dto) {

        User existing = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setEmail(dto.getEmail());
        existing.setIsAdmin(dto.getIsAdmin());

        // Update employee
        if (dto.getEmployeeId() != null) {
            Employee e = employeeRepo.findById(dto.getEmployeeId())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            existing.setEmployee(e);
        } else {
            existing.setEmployee(null);
        }

        // Update roles
        Set<Role> roles = new HashSet<>();
        if (dto.getRoleIds() != null) {
            for (Integer rId : dto.getRoleIds()) {
                Role r = roleRepo.findById(rId)
                        .orElseThrow(() -> new RuntimeException("Role not found"));
                roles.add(r);
            }
        }
        existing.setRoles(roles);

        User saved = userRepo.save(existing);

        UserDto out = mapper.toDto(saved);
        out.setRoleIds(saved.getRoles().stream().map(Role::getRoleId).collect(Collectors.toSet()));
        if (saved.getEmployee() != null) {
            out.setEmployeeId(saved.getEmployee().getEmployeeId());
        }

        return out;
    }

    @Override
    public UserDto findById(Integer id) {

        User u = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserDto out = mapper.toDto(u);

        if (u.getRoles() != null) {
            out.setRoleIds(u.getRoles().stream().map(Role::getRoleId).collect(Collectors.toSet()));
        }

        if (u.getEmployee() != null) {
            out.setEmployeeId(u.getEmployee().getEmployeeId());
        }

        return out;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream().map(user -> {
            UserDto dto = mapper.toDto(user);

            if (user.getRoles() != null) {
                dto.setRoleIds(user.getRoles().stream()
                        .map(Role::getRoleId)
                        .collect(Collectors.toSet()));
            }

            if (user.getEmployee() != null) {
                dto.setEmployeeId(user.getEmployee().getEmployeeId());
            }

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (!userRepo.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepo.deleteById(id);
    }
}
