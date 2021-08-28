package br.com.elasticsearch.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonagemDto {

    private Long dx;

    private Long st;

    private Long ht;

    private Long iq;

    private String jogador;

    private String nome;

    private String descricao;
}
