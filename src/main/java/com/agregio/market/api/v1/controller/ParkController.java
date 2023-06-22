package com.agregio.market.api.v1.controller;


import com.agregio.market.park.model.ParkDto;
import com.agregio.market.park.service.ParkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for park resources. It contains all routes beginning with /park.
 *
 * @param service used to manipulate park element
 */
@RestController
@RequestMapping("/park")
public record ParkController (ParkService service) {

  @PostMapping
  public ParkDto create(@RequestBody final ParkDto park) {
    return service.create(park);
  }

  @GetMapping("/all")
  public List<ParkDto> fetchAll() {
    return service.fetchAll();
  }
}
