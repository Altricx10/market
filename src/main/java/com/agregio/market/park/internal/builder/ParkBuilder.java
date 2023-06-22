package com.agregio.market.park.internal.builder;

import com.agregio.market.park.internal.entity.ParkDao;
import com.agregio.market.park.model.ParkDto;
import com.agregio.market.park.type.ParkType;

/**
 * Responsible for building park element.
 */
public interface ParkBuilder {


  /**
   * Build ParkDto from ParkDao
   *
   * @param park used to build ParkDto.
   * @return a {@link ParkDto}
   */
  static ParkDto toDto(ParkDao park) {
    return new ParkDto(park.getId(), ParkType.valueOf(park.getType()), park.getProduction());
  }

  /**
   * Build ParkDto from ParkDto
   *
   * @param park used to build ParkDao.
   * @return a {@link ParkDao}
   */
  static ParkDao toDao(ParkDto park) {
    return ParkDao.builder()
            .type(park.type().name())
            .production(park.production())
            .id(park.id())
            .build();
  }
}
