package com.agregio.market.offer.model;


import java.time.Instant;

public record BlocDto(
        int id,
        Instant startHour,
        Instant endHour,
        int quantity,
        float floorPrice
) {}
