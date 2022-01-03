package com.alassaneniang.msscbrewery.web.services;

import com.alassaneniang.msscbrewery.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById ( UUID beerId ) {
        return BeerDTO.builder()
                .uuid( UUID.randomUUID() )
                .beerName( "Galaxy Cat" )
                .beerStyle( "Pale Ale" )
                .build();
    }
}
