package com.alassaneniang.msscbrewery.web.services;

import com.alassaneniang.msscbrewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById ( UUID customerId );
}
