package com.turgaydede.util.converter;

import com.turgaydede.entities.Customer;
import com.turgaydede.entities.dtos.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {
    public CustomerDto convert(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .companyId(customer.getCompany().getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }
}
