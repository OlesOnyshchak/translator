package com.translator.controller;

import com.translator.entity.Word;
import com.translator.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    @Qualifier("wordService")
    private WordService wordService;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get() {
        return null;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void save(@RequestBody Word word) {
        wordService.saveWord(word);
    }
}
