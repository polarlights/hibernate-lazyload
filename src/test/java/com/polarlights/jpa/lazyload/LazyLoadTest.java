package com.polarlights.jpa.lazyload;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.polarlights.jpa.lazyload.domain.Award;
import com.polarlights.jpa.lazyload.domain.Bird;
import com.polarlights.jpa.lazyload.domain.Breeder;
import com.polarlights.jpa.lazyload.domain.Cage;
import com.polarlights.jpa.lazyload.domain.Note;
import com.polarlights.jpa.lazyload.domain.Specie;
import com.polarlights.jpa.lazyload.repositories.AwardRepository;
import com.polarlights.jpa.lazyload.repositories.BirdRepository;
import com.polarlights.jpa.lazyload.repositories.BreederRepository;
import com.polarlights.jpa.lazyload.repositories.CageRepository;
import com.polarlights.jpa.lazyload.repositories.NoteRepository;
import com.polarlights.jpa.lazyload.repositories.SpecieRepository;
import com.polarlights.jpa.lazyload.repositories.TreatmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class LazyLoadTest {

    @Autowired
    private AwardRepository awardRepository;
    @Autowired
    private BirdRepository birdRepository;
    @Autowired
    private BreederRepository breederRepository;
    @Autowired
    private CageRepository cageRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private SpecieRepository specieRepository;
    @Autowired
    private NoteRepository noteRepository;

    @BeforeEach
    @Transactional
    void init() {
        final List<Award> awards = new ArrayList<>();
        final Award award1 = new Award();
        award1.setTitile("Award first");
        awards.add(award1);

        final Award award2 = new Award();
        award2.setTitile("Award second");
        awards.add(award2);
        awardRepository.saveAll(awards);

        final Breeder breeder = new Breeder();
        breeder.setName("Breeder One");
        breederRepository.save(breeder);

        final Cage cage = new Cage();
        cage.setName("Cage One");
        cageRepository.save(cage);

        final Specie specie = new Specie();
        specie.setName("Flying birds");
        specieRepository.save(specie);


        final Bird bird = new Bird();
        bird.setBand("bird Band");
        bird.setPicture("what a bird".getBytes());
        bird.setAwards(awards);
        bird.setBreeder(breeder);
        bird.setCage(cage);
        bird.setSpecie(specie);
        birdRepository.save(bird);

        noteRepository.createNote("FirstNote", bird.getId());
        List<Note> abc = noteRepository.findAll();
        noteRepository.createNote("SecondNote", bird.getId());
    }

    @Test
    void findBird() {
        final Optional<Bird> bird = birdRepository.findById(1L);
        bird.get();
    }
}
