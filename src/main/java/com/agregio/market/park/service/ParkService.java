package com.agregio.market.park.service;

import com.agregio.market.park.internal.service.ParkHandleService;
import com.agregio.market.park.model.ParkDto;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Responsible for manipulating park element
 *
 * @param parkHandleService for saving, finding park in database.
 */
@Service
public record ParkService (ParkHandleService parkHandleService) {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(ParkService.class);

  /**
   * Create new park in database.
   *
   * @param park to create
   * @return park created.
   */
  public ParkDto create(ParkDto park) {
    log.info("Create new park | type = {} | production = {}", park.type(), park.production());
    return parkHandleService.create(park);
  }

  /**
   * Retrieve all park present in database
   *
   * @return a {@link List} of {@link ParkDto} found in database
   */
  public List<ParkDto> fetchAll() {
    log.info("Fetching all parks");
    return parkHandleService.fetchAll();
  }
}
