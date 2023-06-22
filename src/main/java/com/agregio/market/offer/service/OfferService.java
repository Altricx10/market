package com.agregio.market.offer.service;

import com.agregio.market.offer.internal.service.OfferHandleService;
import com.agregio.market.offer.model.OfferDto;
import com.agregio.market.park.model.ParkDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Responsible for manipulating offer element
 *
 * @param offerHandleService for saving, finding offer in database.
 */
@Slf4j
@Service
public record OfferService (OfferHandleService offerHandleService) {

  /**
   * Create new offer in database.
   *
   * @param offer to create
   * @return offer created.
   */
  public OfferDto create(OfferDto offer) {
    log.info("Create new offer | market = {} | entity = {} | startHour = {} | endHour = {} | quantity = {} | floorPrice = {} | parks = {}",
            offer.market(),
            offer.entity(),
            offer.bloc().startHour(),
            offer.bloc().endHour(),
            offer.bloc().quantity(),
            offer.bloc().floorPrice(),
            offer.parks().size());
    return offerHandleService.create(offer);
  }

  /**
   * Retrieve all offer present in database
   *
   * @return a {@link List} of {@link OfferDto} found in database
   */
  public List<OfferDto> fetchAll() {
    log.info("Fetching all offer");
    return offerHandleService.fetchAll();
  }
}
