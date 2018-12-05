package com.polarlights.jpa.lazyload.repositories;

import com.polarlights.jpa.lazyload.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface NoteRepository extends JpaRepository<Note, Long> {
   @Modifying
    @Query(value = "insert into note(content, bird_id) values(:content, :birdId)", nativeQuery = true)
    @Transactional
    void createNote(@Param("content") String content, @Param("birdId") Long birdId);
}
