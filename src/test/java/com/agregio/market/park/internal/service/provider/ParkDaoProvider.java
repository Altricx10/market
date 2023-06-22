package com.agregio.market.park.internal.service.provider;

import com.agregio.market.park.internal.entity.ParkDao;

public class ParkDaoProvider {

  public static final Integer ID = 1;

  public static ParkDao buildValidParkDao() {
    return ParkDao.builder()
            .id(ID)
            .production(ParkDtoProvider.PRODUCTION)
            .type(ParkDtoProvider.TYPE.name())
            .build();
  }
}
