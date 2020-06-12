package com.easter.forget;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LetterRepository extends JpaRepository<Letter, String> {

    @Query(nativeQuery=true, value="SELECT * FROM question ORDER BY random() LIMIT 1")
    Optional<Letter> findByRandom();

    @Override
    Letter save(Letter letter);
}
