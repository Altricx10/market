package com.agregio.market.offer.internal.repository;

import com.agregio.market.offer.internal.entity.OfferDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Responsible for manipulating offer element on the database
 */
@Repository
public interface OfferRepository extends JpaRepository<OfferDao, Integer> {}
