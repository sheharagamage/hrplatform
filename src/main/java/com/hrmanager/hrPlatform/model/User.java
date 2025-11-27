package com.hrmanager.hrPlatform.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.Set;

@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String  email;
    private String password;
    private Boolean isAdmin;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JoinColumn(name="employeeId")
    private Employee employee;

    @ManyToMany
    @JoinTable(
            name = "Role",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    private Set<Role> roles;
}
