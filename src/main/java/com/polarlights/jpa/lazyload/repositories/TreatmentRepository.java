package com.polarlights.jpa.lazyload.repositories;

import com.polarlights.jpa.lazyload.domain.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

}
