package com.alassaneniang.msscbrewery.web.services;

import com.alassaneniang.msscbrewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById ( UUID customerId ) {
        return CustomerDTO.builder()
                .id( UUID.randomUUID() )
                .name( "Elon Musk" )
                .build();
    }

    @Override
    public CustomerDTO saveNewCustomer ( CustomerDTO customerDTO ) {
        return CustomerDTO.builder()
                .id( UUID.randomUUID() )
                .name( "Elon Musk" )
                .build();
    }

    @Override
    public void updateCustomer ( UUID customerId, CustomerDTO customerDTO ) {
        // TODO: implement - would update an existing customer
        log.debug( "Updating customer with id: " + customerId );
    }

    @Override
    public void deleteCustomerById ( UUID customerId ) {
        // TODO: implement - would delete an existing customer
        log.debug( "Deleting customer with id: " + customerId );
    }
}
