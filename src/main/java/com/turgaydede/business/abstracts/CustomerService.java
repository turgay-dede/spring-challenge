package com.turgaydede.business.abstracts;

import com.turgaydede.entities.dtos.CompanyDto;
import com.turgaydede.entities.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto add(CustomerDto customerDto);
    CustomerDto delete(int customerId);
    CustomerDto update(CustomerDto customerDto);
    List<CustomerDto> getAll();
    CustomerDto getById(int customerId);
}
