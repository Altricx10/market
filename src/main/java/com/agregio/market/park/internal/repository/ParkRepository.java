package com.agregio.market.park.internal.repository;

import com.agregio.market.park.internal.entity.ParkDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Responsible for manipulating park element on the database
 */
@Repository
public interface ParkRepository extends JpaRepository<ParkDao, Integer> {}
