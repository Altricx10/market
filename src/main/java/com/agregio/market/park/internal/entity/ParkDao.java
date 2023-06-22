package com.agregio.market.park.internal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "park")
@Getter
@Setter(value = AccessLevel.PROTECTED)
@With
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParkDao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name ="id")
  Integer id;

  @Column(name = "type", nullable = false)
  String type;

  @Column(name = "production")
  int production;
}
