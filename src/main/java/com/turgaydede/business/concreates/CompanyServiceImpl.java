package com.turgaydede.business.concreates;

import com.turgaydede.business.abstracts.CompanyService;
import com.turgaydede.entities.Company;
import com.turgaydede.entities.dtos.CompanyDto;
import com.turgaydede.exceptions.CustomerNotFoundException;
import com.turgaydede.repositories.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CompanyDto add(CompanyDto companyDto) {
        Company company = Company.builder().companyName(companyDto.getCompanyName()).build();
        return modelMapper.map(companyRepository.save(company),CompanyDto.class);
    }

    @Override
    public CompanyDto delete(int companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(CustomerNotFoundException::new);
        companyRepository.delete(company);
        return modelMapper.map(company,CompanyDto.class);
    }

    @Override
    public CompanyDto update(CompanyDto companyDto) {
        Company company = Company.builder().id(companyDto.getId()).companyName(companyDto.getCompanyName()).build();
        return modelMapper.map(companyRepository.save(company),CompanyDto.class);
    }

    @Override
    public List<CompanyDto> getAll() {
        return (List<CompanyDto>) companyRepository.findAll().stream().map(company -> modelMapper.map(company,CompanyDto.class));
    }

    @Override
    public CompanyDto getById(int companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(CustomerNotFoundException::new);
        return modelMapper.map(companyRepository.save(company),CompanyDto.class);
    }
}
