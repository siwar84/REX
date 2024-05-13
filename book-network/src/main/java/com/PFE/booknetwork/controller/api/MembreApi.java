package com.PFE.booknetwork.controller.api;

import com.PFE.booknetwork.dto.MembreDto;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.PFE.booknetwork.utils.Constants.APP_ROOT;

public interface MembreApi {
    @PostMapping(value =  APP_ROOT + "/membres/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MembreDto save(@RequestBody MembreDto dto);

    @GetMapping(value = APP_ROOT + "/membres/{idMembre}",  produces = MediaType.APPLICATION_JSON_VALUE)
    MembreDto findById(@PathVariable("idMembre") Integer id);


    @GetMapping(value = APP_ROOT + "/membres/all",  produces = MediaType.APPLICATION_JSON_VALUE)
    List<MembreDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/membres/delete/{idMembre}")
    void delete(@PathVariable("idMembre") Integer id);
}
