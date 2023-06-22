package com.agregio.market.api.v1.controller;

import com.agregio.market.offer.internal.entity.OfferDao;
import com.agregio.market.offer.model.OfferDto;
import com.agregio.market.offer.service.OfferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for offer resources. It contains all routes beginning with /offer.
 *
 * @param service used to manipulate offer element
 */
@RestController
@RequestMapping("/offer")
public record OfferController (OfferService service) {

  @PostMapping
  public OfferDto create(@RequestBody final OfferDto offer) {
    return service.create(offer);
  }

  @GetMapping("/all")
  public List<OfferDto> fetchAll() {
    return service.fetchAll();
  }
}
