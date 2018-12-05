package com.polarlights.jpa.lazyload.repositories;

import com.polarlights.jpa.lazyload.domain.Specie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecieRepository extends JpaRepository<Specie, Long> {

}
