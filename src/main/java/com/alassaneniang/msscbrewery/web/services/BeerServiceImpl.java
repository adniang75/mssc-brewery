package com.alassaneniang.msscbrewery.web.services;

import com.alassaneniang.msscbrewery.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById ( UUID beerId ) {
        return BeerDTO.builder()
                .id( UUID.randomUUID() )
                .beerName( "Galaxy Cat" )
                .beerStyle( "Pale Ale" )
                .build();
    }

    @Override
    public BeerDTO saveNewBeer ( BeerDTO beerDTO ) {
        return BeerDTO.builder()
                .id( UUID.randomUUID() )
                .beerName( beerDTO.getBeerName() )
                .beerStyle( beerDTO.getBeerStyle() )
                .build();
    }

    @Override
    public void updateBeer ( UUID beerId, BeerDTO beerDTO ) {
        // TODO: implement - would update an existing beer
        log.debug( "Updating beer with id: " + beerId );
    }

    @Override
    public void deleteBeerById ( UUID beerId ) {
        // TODO: implement - would delete an existing beer
        log.debug( "Deleting beer with id: " + beerId );
    }
}
