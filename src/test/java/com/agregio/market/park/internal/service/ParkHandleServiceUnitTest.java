package com.agregio.market.park.internal.service;

import com.agregio.market.park.internal.entity.ParkDao;
import com.agregio.market.park.internal.repository.ParkRepository;
import com.agregio.market.park.internal.service.provider.ParkDaoProvider;
import com.agregio.market.park.internal.service.provider.ParkDtoProvider;
import com.agregio.market.park.model.ParkDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DisplayName("Park handle service unit test")
@ExtendWith(MockitoExtension.class)
public class ParkHandleServiceUnitTest {

  @Mock
  ParkRepository repository;

  @InjectMocks ParkHandleService parkHandleService;

  @Nested
  @DisplayName("Given a parkDto without id")
  class GivenParkDtoWithoutId {

    private final ParkDto parkWithoutId = ParkDtoProvider.buildParkDtoWithoutId();

    @BeforeEach
    void setUp() {
      when(repository.save(any(ParkDao.class))).thenReturn(ParkDaoProvider.buildValidParkDao());
    }

    @Nested
    @DisplayName("When calling #create")
    class WhenCallingCreate {

      private ParkDto result;

      @BeforeEach
      void setUp() {
        result = parkHandleService.create(parkWithoutId);
      }

      @Test
      @DisplayName("Then it should return a parkDto with an id")
      void thenItShouldReturnParkDtoWithId() {
        assertThat(result).usingRecursiveComparison().isEqualTo(ParkDtoProvider.buildParkDtoWithId());
      }
    }
  }
}
