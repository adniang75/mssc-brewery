package com.alassaneniang.msscbrewery.web.mappers;

import com.alassaneniang.msscbrewery.domain.Beer;
import com.alassaneniang.msscbrewery.web.model.v2.BeerDTOV2;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    BeerDTOV2 beerToBeerDTOV2 ( Beer beer );

    Beer beerDTOToBeer ( BeerDTOV2 beerDTOV2 );

}
