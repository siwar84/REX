package com.PFE.booknetwork.controller.api;

import com.PFE.booknetwork.dto.EquipeDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.PFE.booknetwork.utils.Constants.APP_ROOT;

public interface EquipeApi {

    @PostMapping(value =  APP_ROOT + "/equipes/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EquipeDto save(@RequestBody EquipeDto dto);

    @GetMapping(value = APP_ROOT + "/equipes/{idEquipe}",  produces = MediaType.APPLICATION_JSON_VALUE)
    EquipeDto findById(@PathVariable("idEquipe") Integer id);


    @GetMapping(value = APP_ROOT + "/equipes/all",  produces = MediaType.APPLICATION_JSON_VALUE)
    List<EquipeDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/equipes/delete/{idEquipe}")
    void delete(@PathVariable("idEquipe") Integer id);
}
