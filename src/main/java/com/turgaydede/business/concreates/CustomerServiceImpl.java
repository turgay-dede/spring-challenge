package com.turgaydede.business.concreates;

import com.turgaydede.business.abstracts.CompanyService;
import com.turgaydede.business.abstracts.CustomerService;
import com.turgaydede.entities.Company;
import com.turgaydede.entities.Customer;
import com.turgaydede.entities.dtos.CustomerDto;
import com.turgaydede.exceptions.CustomerNotFoundException;
import com.turgaydede.repositories.CustomerRepository;
import com.turgaydede.util.converter.CustomerDtoConverter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final CustomerDtoConverter customerDtoConverter;
    private final CompanyService companyService;



    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, CustomerDtoConverter customerDtoConverter, CompanyService companyService) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.customerDtoConverter = customerDtoConverter;
        this.companyService = companyService;
    }

    @Override
    public CustomerDto add(CustomerDto customerDto) {
        Company company = getCompanyByCompanyId(customerDto.getCompanyId());
        Customer customer = Customer.builder()
                .company(company)
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .build();
        return modelMapper.map(customerRepository.save(customer), CustomerDto.class);
    }

    @Override
    public CustomerDto delete(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
        customerRepository.delete(customer);
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto update(CustomerDto customerDto) {
        Company company = getCompanyByCompanyId(customerDto.getCompanyId());
        Customer customer = Customer.builder()
                .id(customerDto.getId())
                .company(company)
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .build();
        return modelMapper.map(customerRepository.save(customer), CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAll() {
        return customerRepository.findAll().stream().map(customerDtoConverter::convert).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getById(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
        return modelMapper.map(customer, CustomerDto.class);
    }

    private Company getCompanyByCompanyId(int companyId){
        return modelMapper.map(companyService.getById(companyId),Company.class);
    }
}
