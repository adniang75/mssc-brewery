package com.alassaneniang.msscbrewery.web.controller.v2;

import com.alassaneniang.msscbrewery.web.model.v2.BeerDTOV2;
import com.alassaneniang.msscbrewery.web.services.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping( "/api/v2/beer" )
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

    public BeerControllerV2 ( BeerServiceV2 beerService ) {
        this.beerService = beerService;
    }

    @GetMapping( { "/{beerId}" } )
    public ResponseEntity<BeerDTOV2> getBeer ( @PathVariable( "beerId" ) UUID beerId ) {
        return new ResponseEntity<>(
                beerService.getBeerById( beerId ),
                HttpStatus.OK
        );
    }

    @PostMapping // POST - create a new beer
    public ResponseEntity<BeerDTOV2> handlePost ( @RequestBody BeerDTOV2 beerDTO ) {
        BeerDTOV2 saveDTO = beerService.saveNewBeer( beerDTO );
        HttpHeaders headers = new HttpHeaders();
        // TODO: add hostname to url
        headers.add( "Location", "/api/v2/beer/" + saveDTO.getId().toString() );
        return new ResponseEntity<>( headers, HttpStatus.CREATED );
    }

    @PutMapping( { "/{beerId}" } ) // PUT - update an existing beer
    public ResponseEntity<BeerDTOV2> handleUpdate ( @PathVariable( "beerId" ) UUID beerId, @RequestBody BeerDTOV2 beerDTO ) {
        beerService.updateBeer( beerId, beerDTO );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }

    @DeleteMapping( { "/{beerId}" } ) // DELETE - delete an existing beer
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void handleDelete ( @PathVariable( "beerId" ) UUID beerId ) {
        beerService.deleteBeerById( beerId );
    }

}
