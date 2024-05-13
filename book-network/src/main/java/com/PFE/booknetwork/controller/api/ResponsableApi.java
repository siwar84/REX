package com.PFE.booknetwork.controller.api;

import com.PFE.booknetwork.dto.ProblematiqueDto;
import com.PFE.booknetwork.dto.ResponsableDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.PFE.booknetwork.utils.Constants.APP_ROOT;

public interface ResponsableApi {

    @PostMapping(value =  APP_ROOT + "/responsables/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponsableDto save(@RequestBody ResponsableDto dto);

    @GetMapping(value = APP_ROOT + "/responsables/{idResponsable}",  produces = MediaType.APPLICATION_JSON_VALUE)
    ResponsableDto findById(@PathVariable("idResponsable") Integer id);



    @GetMapping(value = APP_ROOT + "/responsables/all",  produces = MediaType.APPLICATION_JSON_VALUE)
    List<ResponsableDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/responsables/delete/{idResponsable}")
    void delete(@PathVariable("idResponsable") Integer id);
}
