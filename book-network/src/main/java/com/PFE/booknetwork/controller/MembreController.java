package com.PFE.booknetwork.controller;

import com.PFE.booknetwork.controller.api.MembreApi;
import com.PFE.booknetwork.dto.MembreDto;
import com.PFE.booknetwork.services.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MembreController implements MembreApi {
    @Autowired
    private MembreService membreService;

    @Autowired
    public MembreController(
            MembreService membreService
    ) {
        this.membreService = membreService;
    }

    @Override
    public MembreDto save(MembreDto dto) {
        return membreService.save(dto);
    }

    @Override
    public MembreDto findById(Integer id) {
        return membreService.findById(id);
    }

    @Override
    public List<MembreDto> findAll() {
        return membreService.findAll();
    }

    @Override
    public void delete(Integer id) {
        membreService.delete(id);

    }
}
