package com.PFE.booknetwork.controller;

import com.PFE.booknetwork.controller.api.ResponsableApi;
import com.PFE.booknetwork.dto.ResponsableDto;
import com.PFE.booknetwork.services.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResponsableController implements ResponsableApi {
    @Autowired
    private ResponsableService responsableService;

    @Autowired
    public ResponsableController(
            ResponsableService responsableService
    ) {
        this.responsableService = responsableService;
    }

    @Override
    public ResponsableDto save(ResponsableDto dto) {
        return responsableService.save(dto);
    }

    @Override
    public ResponsableDto findById(Integer id) {
        return responsableService.findById(id);
    }

    @Override
    public List<ResponsableDto> findAll() {
        return responsableService.findAll();
    }

    @Override
    public void delete(Integer id) {
        responsableService.delete(id);

    }
}
