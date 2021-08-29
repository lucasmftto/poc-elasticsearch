package br.com.elasticsearch.dto;

import br.com.elasticsearch.entity.Peculariedade;
import br.com.elasticsearch.entity.Pericia;
import br.com.elasticsearch.entity.VantagemDesvantagens;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Set;

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

    private Set<VantagemDesvantagens> vantagensDesvantagens;

    private Set<Peculariedade> peculariedades;

    private Set<Pericia> pericias;
}
