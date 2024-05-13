package com.PFE.booknetwork.controller.api;

import com.PFE.booknetwork.dto.ProjetDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.PFE.booknetwork.utils.Constants.APP_ROOT;

public interface ProjetApi {

    @PostMapping(value =  APP_ROOT + "/projet/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ProjetDto save(@RequestBody ProjetDto dto);

    @GetMapping(value = APP_ROOT + "/projet/{idProjet}",  produces = MediaType.APPLICATION_JSON_VALUE)
    ProjetDto findById(@PathVariable("idProjet") Integer id);



    @GetMapping(value = APP_ROOT + "/projet/all",  produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProjetDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/projet/delete/{idProjet}")
    void delete(@PathVariable("idProjet") Integer id);
}
