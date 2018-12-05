package com.polarlights.jpa.lazyload.service;

import com.polarlights.jpa.lazyload.domain.Bird;
import com.polarlights.jpa.lazyload.domain.Cage;
import com.polarlights.jpa.lazyload.repositories.BirdRepository;
import com.polarlights.jpa.lazyload.repositories.CageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class BirdService {
   @Autowired
    private BirdRepository birdRepository;
   @Autowired
   private CageRepository cageRepository;

   @Transactional(readOnly = true, rollbackFor = Exception.class)
   public void findBird() {
        log.info("---------> Bird");
        Bird bird = birdRepository.findById(1L).get();
        log.info("---------> Lazy Lob Property picture");
        bird.getPicture();
        log.info("---------> undirectional OneToOne Specie");
        bird.getSpecie().getName();
        log.info("---------> bidirectional OneToOne cage");
        bird.getCage().getName();
        log.info("---------> bidirectional OneToMany awards");
        bird.getAwards().size();
        log.info("---------> undirectional OneToMany notes");
        bird.getNotes().size();
        log.info("---------> bidirectional ManyToOne breeder");
        bird.getBreeder().getName();
   }

   @Transactional(readOnly = true, rollbackFor = Exception.class)
   public void findCage() {
       log.info("---------> Cage");
       Cage cage = cageRepository.findById(1L).get();
       log.info("---------> load bird");
       cage.getBird().getBand();
   }

   @Transactional(rollbackFor = Exception.class)
    public void updateBird() {
       log.info("---------> Bird");
       Bird bird = birdRepository.findById(1L).get();
       bird.setBand("Another band");
       log.info("---------> Bird save");
       birdRepository.save(bird);
   }
}
