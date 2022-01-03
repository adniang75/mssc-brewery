package com.alassaneniang.msscbrewery.web.services.v2;

import com.alassaneniang.msscbrewery.web.model.v2.BeerDTOV2;
import com.alassaneniang.msscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDTOV2 getBeerById ( UUID beerId ) {
        return BeerDTOV2.builder()
                .id( UUID.randomUUID() )
                .beerName( "Galaxy Cat" )
                .beerStyle( BeerStyleEnum.PALE_ALE )
                .build();
    }

    @Override
    public BeerDTOV2 saveNewBeer ( BeerDTOV2 beerDTO ) {
        return BeerDTOV2.builder()
                .id( UUID.randomUUID() )
                .beerName( beerDTO.getBeerName() )
                .beerStyle( beerDTO.getBeerStyle() )
                .build();
    }

    @Override
    public void updateBeer ( UUID beerId, BeerDTOV2 beerDTO ) {
        // TODO: implement - would update an existing beer
        log.debug( "Updating beer with id: " + beerId );
    }

    @Override
    public void deleteBeerById ( UUID beerId ) {
        // TODO: implement - would delete an existing beer
        log.debug( "Deleting beer with id: " + beerId );
    }
}
