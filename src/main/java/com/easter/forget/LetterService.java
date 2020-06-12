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
        Optional<String> letterOptional = letterRepository.findById(1);
        return new LetterResponse(letterOptional.get());
    }

    public void saveLetter(String letter){
        letterRepository.save(letter);
    }
}
