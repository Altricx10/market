package com.agregio.market.park.internal.service.provider;

import com.agregio.market.park.model.ParkDto;
import com.agregio.market.park.type.ParkType;

public class ParkDtoProvider {

  public static final ParkType TYPE = ParkType.HYDRAULIC;
  public static final Integer PRODUCTION = 10;

  public static ParkDto buildParkDtoWithoutId() {
    return new ParkDto(null, TYPE, PRODUCTION);
  }

  public static ParkDto buildParkDtoWithId() {
    return new ParkDto(ParkDaoProvider.ID, TYPE, PRODUCTION);
  }
}
