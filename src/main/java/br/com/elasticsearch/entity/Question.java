package br.com.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document( indexName = "blog")
@Data
public class Question {

    @Id
    private String id;

    private String question;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Answer> answers;

}
