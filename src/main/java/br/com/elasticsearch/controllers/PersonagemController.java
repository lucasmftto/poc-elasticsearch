package br.com.elasticsearch.controllers;

import br.com.elasticsearch.dto.PersonagemDto;
import br.com.elasticsearch.entity.Personagem;
import br.com.elasticsearch.service.PersonagemService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/personagem")
@CrossOrigin("*")
public class PersonagemController {

    @Autowired
    PersonagemService personagemService;

    @ApiOperation(value = "Pesquisa todas Perguntas")
    @GetMapping
    public Page<Personagem> findByNome(@RequestParam(value = "nome", required = false, defaultValue = "") String nome){
        MDC.clear();
        MDC.put("Find Personagem By Nome: ", String.valueOf(UUID.randomUUID()));
        return this.personagemService.findByNome(nome, PageRequest.of(0, 10));
    }

    @ApiOperation(value = "POC Elasticsearch")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Personagem inserePersonagem(@RequestBody @Valid PersonagemDto personagemDto) {
        MDC.clear();
        MDC.put("POC Elasticsearch inserePersonagem: ", String.valueOf(UUID.randomUUID()));

        return personagemService.savePersonagem(personagemDto);
    }

    @ApiOperation(value = "Deleta Personagem")
    @DeleteMapping("{nome}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String nome) {
        MDC.clear();
        MDC.put("Delete Personagem: ", String.valueOf(UUID.randomUUID()));
        this.personagemService.deleteByNome(nome);
    }

    @ApiOperation(value = "Pesquisa todas Perguntas template")
    @GetMapping("/template")
    public SearchHits<Personagem> findByNomeTemplate(@RequestParam(value = "nome", required = false, defaultValue = "") String nome){
        MDC.clear();
        MDC.put("Find Personagem By Nome: ", String.valueOf(UUID.randomUUID()));
        return this.personagemService.findByNomeTemplate(nome);
    }

}
