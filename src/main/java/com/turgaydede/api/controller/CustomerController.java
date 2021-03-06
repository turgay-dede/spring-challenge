package com.turgaydede.api.controller;

import com.turgaydede.business.abstracts.CustomerService;
import com.turgaydede.entities.dtos.CompanyDto;
import com.turgaydede.entities.dtos.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomerDto> add(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.add(customerDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CustomerDto> delete(@RequestParam int customerId){
        return ResponseEntity.ok(customerService.delete(customerId));
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.update(customerDto));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CustomerDto>> getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/get/byid")
    public ResponseEntity<CustomerDto> getById(@RequestParam int customerId){
        return ResponseEntity.ok(customerService.getById(customerId));
    }
}
