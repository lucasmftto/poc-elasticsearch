package br.com.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Set;

@Document( indexName = "personagem")
@Data
public class Personagem {

    @Id
    private String id;

    private Long dx;

    private Long st;

    private Long ht;

    private Long iq;

    private String jogador;

    private String nome;

    private String descricao;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Set<VantagemDesvantagens> vantagensDesvantagens;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Set<Peculariedade> peculariedades;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Set<Pericia> pericias;
}
