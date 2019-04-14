package com.smecosystem_rest.smecosystem_rest.controller;


import com.smecosystem_rest.smecosystem_rest.exception.ResourceNotFoundException;
import com.smecosystem_rest.smecosystem_rest.model.Company;
import com.smecosystem_rest.smecosystem_rest.repositories.CompanyRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/companyRestService")
public class CompanyController {

    @Autowired
    private CompanyRepositoryImpl companyRepositoryImpl;

    @GetMapping("/list")
    public List<Company> getAllUsers() {
        return companyRepositoryImpl.findAll();
    }


    @GetMapping("/getCompanyById/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable(value = "id") Long companyId) throws ResourceNotFoundException {
        Company company =  companyRepositoryImpl.findById(companyId) .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ companyId));
        return ResponseEntity.ok().body(company);
    }


}
