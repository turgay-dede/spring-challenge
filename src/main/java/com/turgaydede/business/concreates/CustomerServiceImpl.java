package com.turgaydede.business.concreates;

import com.turgaydede.business.abstracts.CustomerService;
import com.turgaydede.entities.Customer;
import com.turgaydede.entities.dtos.CustomerDto;
import com.turgaydede.exceptions.CustomerNotFoundException;
import com.turgaydede.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto add(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .companyId(customerDto.getId())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .build();
        return modelMapper.map(customerRepository.save(customer),CustomerDto.class);
    }

    @Override
    public CustomerDto delete(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
        customerRepository.delete(customer);
        return modelMapper.map(customer,CustomerDto.class);
    }

    @Override
    public CustomerDto update(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .id(customerDto.getId())
                .companyId(customerDto.getId())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .build();
        return modelMapper.map(customerRepository.save(customer),CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAll() {
        return (List<CustomerDto>) customerRepository.findAll().stream().map(customer -> modelMapper.map(customer,CustomerDto.class));
    }

    @Override
    public CustomerDto getById(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
        return modelMapper.map(customer,CustomerDto.class);
    }
}
