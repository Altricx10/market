package com.agregio.market.park.internal.service;

import com.agregio.market.park.internal.entity.ParkDao;
import com.agregio.market.park.internal.builder.ParkBuilder;
import com.agregio.market.park.internal.repository.ParkRepository;
import com.agregio.market.park.model.ParkDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Responsible for handling parks
 *
 * @param repository to manipulate ParkDao
 */
@Service
public record ParkHandleService(ParkRepository repository) {

  /**
   * Create new Park in database
   *
   * @param park a {@link ParkDto} to create
   * @return a {@link ParkDto} created
   */
  public ParkDto create(ParkDto park) {
    ParkDao parkToCreate = ParkBuilder.toDao(park);
    ParkDao parkCreated = repository.save(parkToCreate);
    return ParkBuilder.toDto(parkCreated);
  }

  /**
   * Fetching all park present in database
   *
   * @return a {@link List} of {@link ParkDto} found in database
   */
  public List<ParkDto> fetchAll() {
    List<ParkDao> parks = repository.findAll();
    return parks.stream().map(ParkBuilder::toDto).toList();
  }
}
