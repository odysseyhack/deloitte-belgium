package com.smecosystem_rest.smecosystem_rest.services;

import com.smecosystem_rest.smecosystem_rest.repositories.SmartcontractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartContractService {

    @Autowired
    SmartcontractRepository smartcontractRepository;



}
