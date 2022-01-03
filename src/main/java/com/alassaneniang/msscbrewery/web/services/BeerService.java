package com.alassaneniang.msscbrewery.web.services;

import com.alassaneniang.msscbrewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {

    BeerDTO getBeerById ( UUID beerId );

    BeerDTO saveNewBeer ( BeerDTO beerDTO );

    void updateBeer ( UUID beerId, BeerDTO beerDTO );

    void deleteBeerById ( UUID beerId );

}
