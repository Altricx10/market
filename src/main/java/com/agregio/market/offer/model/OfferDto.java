package com.agregio.market.offer.model;

import com.agregio.market.offer.type.MarketType;
import com.agregio.market.park.model.ParkDto;
import lombok.With;

import java.util.Set;

@With
public record OfferDto(

        int id,
        MarketType market,
        BlocDto bloc,
        String entity,
        Set<ParkDto> parks
) {}
