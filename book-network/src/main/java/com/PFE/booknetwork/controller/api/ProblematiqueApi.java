package com.PFE.booknetwork.controller.api;

import com.PFE.booknetwork.dto.ProblematiqueDto;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.PFE.booknetwork.utils.Constants.APP_ROOT;

public interface ProblematiqueApi {

    @PostMapping(value =  APP_ROOT + "/problematiques/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ProblematiqueDto save(@RequestBody ProblematiqueDto dto);

    @GetMapping(value = APP_ROOT + "/problematiques/{idProblematique}",  produces = MediaType.APPLICATION_JSON_VALUE)
    ProblematiqueDto findById(@PathVariable("idProblematique") Integer id);



    @GetMapping(value = APP_ROOT + "/problematiques/all",  produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProblematiqueDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/problematiques/delete/{idProblematique}")
    void delete(@PathVariable("idProblematique") Integer id);
}
