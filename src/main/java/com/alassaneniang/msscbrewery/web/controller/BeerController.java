package com.alassaneniang.msscbrewery.web.controller;

import com.alassaneniang.msscbrewery.web.model.BeerDTO;
import com.alassaneniang.msscbrewery.web.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Deprecated
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
    public ResponseEntity<BeerDTO> handlePost ( @Valid @RequestBody BeerDTO beerDTO ) {
        BeerDTO saveDTO = beerService.saveNewBeer( beerDTO );
        HttpHeaders headers = new HttpHeaders();
        // TODO: add hostname to url
        headers.add( "Location", "/api/v1/beer/" + saveDTO.getId().toString() );
        return new ResponseEntity<>( headers, HttpStatus.CREATED );
    }

    @PutMapping( { "/{beerId}" } ) // PUT - update an existing beer
    public ResponseEntity<BeerDTO> handleUpdate ( @PathVariable( "beerId" ) UUID beerId, @Valid @RequestBody BeerDTO beerDTO ) {
        beerService.updateBeer( beerId, beerDTO );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }

    @DeleteMapping( { "/{beerId}" } ) // DELETE - delete an existing beer
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void handleDelete ( @PathVariable( "beerId" ) UUID beerId ) {
        beerService.deleteBeerById( beerId );
    }


}
