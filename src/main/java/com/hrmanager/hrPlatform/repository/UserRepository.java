package com.hrmanager.hrPlatform.repository;

import com.hrmanager.hrPlatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
