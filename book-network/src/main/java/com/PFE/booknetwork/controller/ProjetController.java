package com.PFE.booknetwork.controller;


import com.PFE.booknetwork.controller.api.ProjetApi;
import com.PFE.booknetwork.dto.ProjetDto;
import com.PFE.booknetwork.services.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjetController implements ProjetApi {

    @Autowired
    private ProjetService projetService;
    @Autowired
    public ProjetController(
            ProjetService projetService
    ) {
        this.projetService = projetService;
    }

    @Override
    public ProjetDto save(ProjetDto dto) {
        return projetService.save(dto);
    }

    @Override
    public ProjetDto findById(Integer id) {
        return projetService.findById(id);
    }



    @Override
    public List<ProjetDto> findAll() {
        return projetService.findAll();
    }

    @Override
    public void delete(Integer id) {
        projetService.delete(id);

    }


}
