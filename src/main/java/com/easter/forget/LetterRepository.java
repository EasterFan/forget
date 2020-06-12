package com.easter.forget;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LetterRepository extends JpaRepository<Letter, String> {

    @Query(nativeQuery=true, value="SELECT * FROM letter AS t1 JOIN \n" +
            "(SELECT ROUND(RAND() * ((SELECT MAX(id) FROM letter)-(SELECT MIN(id) FROM letter))+(SELECT MIN(id) FROM letter)) AS id) AS t2 \n" +
            "WHERE t1.id >= t2.id ORDER BY t1.id LIMIT 1;")
    Optional<Letter> findByRandom();

    @Override
    Letter save(Letter letter);
}
