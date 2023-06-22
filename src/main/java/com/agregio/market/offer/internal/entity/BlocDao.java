package com.agregio.market.offer.internal.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "bloc")
@Getter
@With
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BlocDao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  int id;

  @Column(name = "start_hour")
  Instant startHour;

  @Column(name = "end_hour")
  Instant endHour;

  @Column(name = "quantity")
  int quantity;

  @Column(name = "floor_price")
  float floorPrice;
}
