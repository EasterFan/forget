package com.easter.forget;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/letter")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Controller {
    private final LetterService letterService;

    @PostMapping
    @CrossOrigin
    public void saveALetter(@RequestBody LetterRequest letter) {
        letterService.saveLetter(letter.letter);
    }

    @GetMapping
    @CrossOrigin
    public LetterResponse readALetterByRandom() {
        return letterService.readALetter();
    }
}
