package br.com.elasticsearch.repository;

import br.com.elasticsearch.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends ElasticsearchRepository<Question, String> {

    Page<Question> findByAnswersAnswer(String name, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"answers.answer\": \"?0\"}}]}}")
    Page<Question> findByAuthorsNameUsingCustomQuery(String answer, Pageable pageable);
}
