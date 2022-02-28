package com.turgaydede.api.controller;

import com.turgaydede.business.abstracts.CompanyService;
import com.turgaydede.entities.dtos.CompanyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/add")
    public ResponseEntity<CompanyDto> add(@RequestBody CompanyDto companyDto){
        return ResponseEntity.ok(companyService.add(companyDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CompanyDto> delete(@RequestParam int companyId){
        return ResponseEntity.ok(companyService.delete(companyId));
    }

    @PutMapping("/update")
    public ResponseEntity<CompanyDto> update(@RequestBody CompanyDto companyDto){
        return ResponseEntity.ok(companyService.update(companyDto));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CompanyDto>> getAll(){
        return ResponseEntity.ok(companyService.getAll());
    }

    @GetMapping("/get/byid")
    public ResponseEntity<CompanyDto> getById(@RequestParam int companyId){
        return ResponseEntity.ok(companyService.getById(companyId));
    }
}
