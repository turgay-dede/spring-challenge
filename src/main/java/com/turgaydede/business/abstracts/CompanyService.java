package com.turgaydede.business.abstracts;

import com.turgaydede.entities.dtos.CompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto add(CompanyDto companyDto);
    CompanyDto delete(int companyId);
    CompanyDto update(CompanyDto companyDto);
    List<CompanyDto> getAll();
    CompanyDto getById(int companyId);
}
