package com.alassaneniang.msscbrewery.web.controller;

import com.alassaneniang.msscbrewery.web.model.CustomerDTO;
import com.alassaneniang.msscbrewery.web.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping( "/api/v1/customer" )
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController ( CustomerService customerService ) {
        this.customerService = customerService;
    }

    @GetMapping( { "/{customerId}" } )
    public ResponseEntity<CustomerDTO> getCustomer ( @PathVariable( "customerId" ) UUID customerId ) {
        return new ResponseEntity<>(
                customerService.getCustomerById( customerId ),
                HttpStatus.OK
        );
    }

    @PostMapping // POST - create a new customer
    public ResponseEntity<CustomerDTO> handlePost ( @Valid @RequestBody CustomerDTO customerDTO ) {
        CustomerDTO saveDTO = customerService.saveNewCustomer( customerDTO );
        HttpHeaders headers = new HttpHeaders();
        // TODO: add hostname to url
        headers.add( "Location", "/api/v1/customer/" + saveDTO.getId().toString() );
        return new ResponseEntity<>( headers, HttpStatus.CREATED );
    }

    @PutMapping( { "/{customerId}" } ) // PUT - update an existing customer
    public ResponseEntity<CustomerDTO> handleUpdate ( @PathVariable( "customerId" ) UUID customerId, @Valid @RequestBody CustomerDTO customerDTO ) {
        customerService.updateCustomer( customerId, customerDTO );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }

    @DeleteMapping( { "/{customerId}" } ) // DELETE - delete an existing customer
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void handleDelete ( @PathVariable( "customerId" ) UUID customerId ) {
        customerService.deleteCustomerById( customerId );
    }

    @ExceptionHandler( ConstraintViolationException.class )
    public ResponseEntity<List<String>> validationErrorHandler ( ConstraintViolationException exception ) {
        List<String> errors = new ArrayList<>( exception.getConstraintViolations().size() );
        exception.getConstraintViolations()
                .forEach( constraintViolation -> errors.add( constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage() ) );
        return new ResponseEntity<>( errors, HttpStatus.BAD_REQUEST );
    }

}
