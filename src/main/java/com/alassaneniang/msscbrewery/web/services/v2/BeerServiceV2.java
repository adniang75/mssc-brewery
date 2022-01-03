package com.alassaneniang.msscbrewery.web.services.v2;

import com.alassaneniang.msscbrewery.web.model.v2.BeerDTOV2;

import java.util.UUID;

public interface BeerServiceV2 {

    BeerDTOV2 getBeerById ( UUID beerId );

    BeerDTOV2 saveNewBeer ( BeerDTOV2 beerDTO );

    void updateBeer ( UUID beerId, BeerDTOV2 beerDTO );

    void deleteBeerById ( UUID beerId );
}
