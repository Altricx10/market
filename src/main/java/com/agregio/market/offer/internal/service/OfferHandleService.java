package com.agregio.market.offer.internal.service;

import com.agregio.market.offer.internal.builder.OfferBuilder;
import com.agregio.market.offer.internal.entity.OfferDao;
import com.agregio.market.offer.internal.repository.OfferRepository;
import com.agregio.market.offer.model.OfferDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Responsible for handling offers
 *
 * @param repository to manipulate OfferDao
 */
@Service
public record OfferHandleService(OfferRepository repository) {

  /**
   * Create new offer in database
   *
   * @param offer a {@link OfferDto} to create
   * @return a {@link OfferDto} created
   */
  public OfferDto create(OfferDto offer) {
    OfferDao offerToCreate = OfferBuilder.build(offer);
    OfferDao offerCreated = repository.save(offerToCreate);

    return OfferBuilder.build(offerCreated);
  }

  /**
   * Fetching all offer present in database
   *
   * @return a {@link List} of {@link OfferDto} found in database
   */
  public List<OfferDto> fetchAll() {
    List<OfferDao> offers = repository.findAll();

    return offers.stream().map(OfferBuilder::build).toList();
  }
}
