package com.easter.forget;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Controller {
    @PostMapping
    public LetterResponse readALetterByRandom(){

    }
}
