package com.alassaneniang.msscbrewery.web.controller;

import com.alassaneniang.msscbrewery.web.model.BeerDTO;
import com.alassaneniang.msscbrewery.web.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping( "/api/v1/beer" )
public class BeerController {

    private final BeerService beerService;

    public BeerController ( BeerService beerService ) {
        this.beerService = beerService;
    }

    @GetMapping( { "/{beerId}" } )
    public ResponseEntity<BeerDTO> getBeer ( @PathVariable( "beerId" ) UUID beerId ) {
        return new ResponseEntity<>(
                beerService.getBeerById( beerId ),
                HttpStatus.OK
        );
    }

    @PostMapping // POST - create a new beer
    public ResponseEntity<BeerDTO> handlePost ( @RequestBody BeerDTO beerDTO ) {
        BeerDTO saveDTO = beerService.saveNewBeer( beerDTO );
        HttpHeaders headers = new HttpHeaders();
        // TODO: add hostname to url
        headers.add( "Location", "/api/v1/beer/" + saveDTO.getId().toString() );
        return new ResponseEntity<>( headers, HttpStatus.CREATED );
    }

}
