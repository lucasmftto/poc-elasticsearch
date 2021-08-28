package br.com.elasticsearch.service;

import br.com.elasticsearch.dto.PersonagemDto;
import br.com.elasticsearch.entity.Personagem;
import br.com.elasticsearch.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonagemServiceImpl implements PersonagemService{

    @Autowired
    PersonagemRepository personagemRepository;

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

        return this.personagemRepository.save(personagem);
    }

    @Override
    public Page<Personagem> findByNome(String nome, Pageable pageable) {
        return this.personagemRepository.findByNome(nome, pageable);
    }
}
