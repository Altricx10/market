package com.agregio.market.offer.internal.builder;


import com.agregio.market.offer.internal.entity.BlocDao;
import com.agregio.market.offer.model.BlocDto;
import com.agregio.market.offer.internal.entity.OfferDao;
import com.agregio.market.offer.model.OfferDto;
import com.agregio.market.offer.type.MarketType;
import com.agregio.market.park.internal.builder.ParkBuilder;
import com.agregio.market.park.internal.entity.ParkDao;
import com.agregio.market.park.model.ParkDto;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Responsible for building offer element.
 */
public interface OfferBuilder {

  /**
   * Build OfferDto from OfferDao and BlocDto
   *
   * @param offer used to build OfferDto.
   * @return a {@link OfferDto}
   */
  static OfferDto build(OfferDao offer) {

    BlocDto bloc = BlocBuilder.build(offer.getBloc());
    Set<ParkDto> parks = offer.getParks().stream().map(ParkBuilder::toDto).collect(Collectors.toSet());

    return new OfferDto(
        offer.getId(),
        MarketType.valueOf(offer.getMarket()),
        bloc,
        offer.getEntity(),
        parks);
  }

  /**
   * Build OfferDao from OfferDto
   *
   * @param offer used to build OfferDao.
   * @return a {@link OfferDao}
   */
  static OfferDao build(OfferDto offer) {

    BlocDao bloc = BlocBuilder.build(offer.bloc());
    Set<ParkDao> parks = offer.parks().stream().map(ParkBuilder::toDao).collect(Collectors.toSet());

    return OfferDao.builder()
            .id(offer.id())
            .bloc(bloc)
            .market(offer.market().name())
            .entity(offer.entity())
            .parks(parks)
            .build();
  }
}
