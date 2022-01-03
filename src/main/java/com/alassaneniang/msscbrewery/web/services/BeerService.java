package com.alassaneniang.msscbrewery.web.services;

import com.alassaneniang.msscbrewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById ( UUID beerId );
}
