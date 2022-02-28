package com.turgaydede.entities.dtos;

import lombok.Data;

@Data
public class CustomerDto {
    private int id;
    private int companyId;
    private String firstName;
    private String lastName;
}
