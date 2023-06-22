package com.agregio.market.offer.internal.builder;

import com.agregio.market.offer.internal.entity.BlocDao;
import com.agregio.market.offer.model.BlocDto;

/**
 * Responsible for building bloc element.
 */
public interface BlocBuilder {

  /**
   * Build BlocDto from BlocDao
   *
   * @param bloc used to build BlocDto.
   * @return a {@link BlocDto}
   */
  static BlocDto build(BlocDao bloc) {
    return new BlocDto(bloc.getId(),
            bloc.getStartHour(),
            bloc.getEndHour(),
            bloc.getQuantity(),
            bloc.getFloorPrice());
  }

  /**
   * Build BlocDao from BlocDto
   *
   * @param bloc used to build BlocDao.
   * @return a {@link BlocDao}
   */
  static BlocDao build(BlocDto bloc) {
    return BlocDao.builder()
            .id(bloc.id())
            .startHour(bloc.startHour())
            .endHour(bloc.endHour())
            .floorPrice(bloc.floorPrice())
            .quantity(bloc.quantity())
            .build();
  }
}
