package com.PFE.booknetwork.controller;

import com.PFE.booknetwork.controller.api.ProblematiqueApi;
import com.PFE.booknetwork.dto.ProblematiqueDto;
import com.PFE.booknetwork.services.ProblematiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProblematiqueController implements ProblematiqueApi {
    @Autowired
    private ProblematiqueService problematiqueService;

    @Autowired
    public ProblematiqueController(
            ProblematiqueService problematiqueService
    ) {
        this.problematiqueService = problematiqueService;
    }

    @Override
    public ProblematiqueDto save(ProblematiqueDto dto) {

        return problematiqueService.save(dto);
    }

    @Override
    public ProblematiqueDto findById(Integer id) {

        return problematiqueService.findById(id);
    }

    @Override
    public List<ProblematiqueDto> findAll() {

        return problematiqueService.findAll();
    }

    @Override
    public void delete(Integer id) {
        problematiqueService.delete(id);

    }
}
