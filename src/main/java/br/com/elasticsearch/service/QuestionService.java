package br.com.elasticsearch.service;

import br.com.elasticsearch.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {
    void saveQuestion(Question question);

    Page<Question> findByAnswersAnswer(String name, Pageable pageable);
}
