package com.turgaydede.util.converter;

import com.turgaydede.entities.Company;
import com.turgaydede.entities.dtos.CompanyDto;
import org.springframework.stereotype.Component;

@Component
public class CompanyDtoConverter {
    public CompanyDto convert(Company company){
        return CompanyDto.builder().id(company.getId()).companyName(company.getCompanyName()).build();
    }
}
