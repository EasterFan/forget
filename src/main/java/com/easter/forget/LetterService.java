package com.easter.forget;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LetterService {
    private final LetterRepository letterRepository;

    public LetterResponse readALetter() {
        Optional<Letter> letterOptional = letterRepository.findByRandom();
        String originMessage = letterOptional.get().getLetter();
        String message = originMessage.substring(originMessage.indexOf("\n"));

        String title = originMessage.substring(0, originMessage.indexOf("\n"));

        return new LetterResponse(title, message);
    }

    public void saveLetter(String letter) {
        if (!StringUtils.isEmpty(letter)) {
            letterRepository.save(new Letter(letter));
        }
    }
}
