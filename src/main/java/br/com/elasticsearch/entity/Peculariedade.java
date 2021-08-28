package br.com.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document( indexName = "personagem")
@Data
public class Peculariedade {

    @Id
    private String id;

    private String nome;

    private Long pontos;

}