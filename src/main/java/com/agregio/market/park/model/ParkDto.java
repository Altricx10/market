package com.agregio.market.park.model;

import com.agregio.market.park.type.ParkType;
import lombok.With;

@With
public record ParkDto (

  Integer id,
  ParkType type,
  int production
) {}
