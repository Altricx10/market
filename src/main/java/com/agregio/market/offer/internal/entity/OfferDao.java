package com.agregio.market.offer.internal.entity;

import com.agregio.market.park.internal.entity.ParkDao;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "offer")
@Getter
@Setter(value = AccessLevel.PROTECTED)
@With
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OfferDao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  int id;

  @Column(name = "market", nullable = false)
  String market;

  @OneToOne(optional = false, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
  @JoinColumn(name = "bloc_id", nullable = false)
  BlocDao bloc;

  @Column(name = "entity", nullable = false)
  String entity;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "offer_park",
  joinColumns = @JoinColumn(name = "offer_id"),
  inverseJoinColumns = @JoinColumn(name = "park_id"))
  Set<ParkDao> parks;
}
