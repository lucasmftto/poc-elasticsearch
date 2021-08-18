package br.com.elasticsearch.controllers;

import br.com.elasticsearch.entity.Answer;
import br.com.elasticsearch.entity.Question;
import br.com.elasticsearch.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/elasticsearch")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ElasticsearchController {

    @Autowired
    QuestionService questionService;

    @ApiOperation(value = "POC Elasticsearch")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean test() {
        MDC.clear();
        MDC.put("POC Elasticsearch: ", String.valueOf(UUID.randomUUID()));

        Question q = new Question();
        q.setQuestion("O que é Java2");
        q.setAnswers(Arrays.asList(new Answer("Linguagem"), new Answer("Programacao")));

        questionService.saveQuestion(q);
        return true;
    }

    @ApiOperation(value = "Pesquisa todas Perguntas")
    @GetMapping
    public Page<Question> findAll(@RequestParam(value = "resposta", required = false, defaultValue = "") String resposta){
        MDC.clear();
        MDC.put("Find All by resposta: ", String.valueOf(UUID.randomUUID()));
        return this.questionService.findByAnswersAnswer(resposta, PageRequest.of(0, 10));
    }

}
