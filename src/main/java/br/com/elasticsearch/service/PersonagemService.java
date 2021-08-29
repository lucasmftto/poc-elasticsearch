package br.com.elasticsearch.service;

import br.com.elasticsearch.dto.PersonagemDto;
import br.com.elasticsearch.entity.Personagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHits;

public interface PersonagemService {

    Personagem savePersonagem(PersonagemDto personagemDto);

    Page<Personagem> findByNome(String nome, Pageable pageable);

    SearchHits<Personagem> findByNomeTemplate(String nome);

    void deleteByNome(String nome);
}
