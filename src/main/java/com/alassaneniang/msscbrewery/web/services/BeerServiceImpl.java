package com.alassaneniang.msscbrewery.web.services;

import com.alassaneniang.msscbrewery.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
        // TODO: implement - would add a real beer update
    }
}
