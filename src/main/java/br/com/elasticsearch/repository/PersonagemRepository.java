package br.com.elasticsearch.repository;

import br.com.elasticsearch.entity.Personagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PersonagemRepository extends ElasticsearchRepository<Personagem, String> {

    Page<Personagem> findByNome(String nome, Pageable pageable);
}
