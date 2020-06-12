package com.easter.forget;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LetterService {
    private final LetterRepository letterRepository;

    public LetterResponse readALetter(){
        Optional<Letter> letterOptional = letterRepository.findByRandom();
        return new LetterResponse(letterOptional.get().getLetter());
    }

    public void saveLetter(String letter){
        letterRepository.save(new Letter(letter));
    }
}
