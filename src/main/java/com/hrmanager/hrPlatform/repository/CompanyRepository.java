package com.hrmanager.hrPlatform.repository;

import com.hrmanager.hrPlatform.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CompanyRepository extends JpaRepository<Company , Integer> {

}
