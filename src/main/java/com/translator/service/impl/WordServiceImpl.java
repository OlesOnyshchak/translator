package com.translator.service.impl;

import com.translator.dao.WordRepository;
import com.translator.entity.Word;
import com.translator.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("wordService")
public class WordServiceImpl implements WordService {

    @Autowired
    @Qualifier("wordRepository")
    private WordRepository wordRepository;

    @Override
    public void saveWord(Word word) {
        wordRepository.create(word);
    }
}
