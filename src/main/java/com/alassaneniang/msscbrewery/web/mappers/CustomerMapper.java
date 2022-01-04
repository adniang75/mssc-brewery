package com.alassaneniang.msscbrewery.web.mappers;

import com.alassaneniang.msscbrewery.domain.Customer;
import com.alassaneniang.msscbrewery.web.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDTO customerToCustomerDTO ( Customer customer );

    Customer customerDTOToCustomer ( CustomerDTO customerDTO );

}
