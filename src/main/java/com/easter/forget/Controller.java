package com.easter.forget;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/letter")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Controller {
    private final LetterService letterService;

    @PostMapping
    public void saveALetter(String letter) {
        letterService.saveLetter(letter);
    }

    @GetMapping
    public LetterResponse readALetterByRandom() {
        return letterService.readALetter();
    }
}
