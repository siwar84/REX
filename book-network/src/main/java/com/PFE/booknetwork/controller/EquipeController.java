package com.PFE.booknetwork.controller;

import com.PFE.booknetwork.controller.api.EquipeApi;
import com.PFE.booknetwork.dto.EquipeDto;
import com.PFE.booknetwork.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipeController implements EquipeApi {

    @Autowired
    private EquipeService equipeService;

    @Autowired
    public EquipeController(
            EquipeService equipeService
    ) {
        this.equipeService = equipeService;
    }

    @Override
    public EquipeDto save(EquipeDto dto) {
        return equipeService.save(dto);
    }

    @Override
    public EquipeDto findById(Integer id) {
        return equipeService.findById(id);
    }

    @Override
    public List<EquipeDto> findAll() {
        return equipeService.findAll();
    }

    @Override
    public void delete(Integer id) {
        equipeService.delete(id);

    }
}
