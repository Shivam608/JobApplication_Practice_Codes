package com.edu.FirstJobApplication.Companies;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
