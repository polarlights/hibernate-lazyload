package com.polarlights.jpa.lazyload.repositories;

import com.polarlights.jpa.lazyload.domain.Award;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardRepository extends JpaRepository<Award, Long> {

}
