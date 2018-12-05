package com.polarlights.jpa.lazyload.repositories;

import com.polarlights.jpa.lazyload.domain.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdRepository extends JpaRepository<Bird, Long> {

}
