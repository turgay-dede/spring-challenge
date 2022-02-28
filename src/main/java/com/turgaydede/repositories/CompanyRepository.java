package com.turgaydede.repositories;

import com.turgaydede.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
