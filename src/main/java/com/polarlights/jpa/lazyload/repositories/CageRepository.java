package com.polarlights.jpa.lazyload.repositories;

import com.polarlights.jpa.lazyload.domain.Cage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CageRepository extends JpaRepository<Cage, Long> {

}
