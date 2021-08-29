package br.com.elasticsearch.service;

import br.com.elasticsearch.dto.PersonagemDto;
import br.com.elasticsearch.entity.Personagem;
import br.com.elasticsearch.repository.PersonagemRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

@Service
public class PersonagemServiceImpl implements PersonagemService{

    @Autowired
    PersonagemRepository personagemRepository;

    @Autowired
    ElasticsearchRestTemplate template;

    @Override
    public Personagem savePersonagem(PersonagemDto personagemDto) {
        Personagem personagem = new Personagem();

        personagem.setDescricao(personagemDto.getDescricao());
        personagem.setDx(personagemDto.getDx());
        personagem.setHt(personagemDto.getHt());
        personagem.setIq(personagemDto.getIq());
        personagem.setSt(personagemDto.getSt());
        personagem.setJogador(personagemDto.getJogador());
        personagem.setNome(personagemDto.getNome());
        personagem.setDescricao(personagemDto.getDescricao());
        personagem.setVantagensDesvantagens(personagemDto.getVantagensDesvantagens());
        personagem.setPericias(personagemDto.getPericias());
        personagem.setPeculariedades(personagemDto.getPeculariedades());

        return this.personagemRepository.save(personagem);
    }

    @Override
    public Page<Personagem> findByNome(String nome, Pageable pageable) {
        return this.personagemRepository.findByNome(nome, pageable);
    }

    @Override
    public SearchHits<Personagem> findByNomeTemplate(String nome) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("nome", "Burak"))
                .build();
        SearchHits<Personagem> personagem = template.search(searchQuery, Personagem.class, IndexCoordinates.of("personagem"));
        return personagem;
    }

    @Override
    public void deleteByNome(String nome) {
        this.personagemRepository.deleteByNome(nome);
    }
}
