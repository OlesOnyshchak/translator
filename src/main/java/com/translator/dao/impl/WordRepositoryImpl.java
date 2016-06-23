package com.translator.dao.impl;

import com.translator.dao.CrudRepository;
import com.translator.dao.WordRepository;
import com.translator.entity.Word;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("wordRepository")
public class WordRepositoryImpl extends CrudRepositoryImpl<Word> implements WordRepository {
}
