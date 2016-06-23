package com.translator.service;

import com.translator.entity.Word;
import org.springframework.transaction.annotation.Transactional;

public interface WordService {
    @Transactional
    void saveWord(Word word);
}
