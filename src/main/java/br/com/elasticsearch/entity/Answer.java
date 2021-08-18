package br.com.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document( indexName = "blog")
@Data
public class Answer {

    @Id
    private String id;

    private String answer;

    public Answer(String answer) {
        this.answer = answer;
    }
}
