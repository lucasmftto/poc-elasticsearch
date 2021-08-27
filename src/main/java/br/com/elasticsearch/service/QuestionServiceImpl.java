package br.com.elasticsearch.service;

import br.com.elasticsearch.entity.Question;
import br.com.elasticsearch.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    private ElasticsearchRestTemplate template;

    @Override
    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Page<Question> findByAnswersAnswer(String name, Pageable pageable) {
        return questionRepository.findByAnswersAnswer(name, pageable);
    }
}
