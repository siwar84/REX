package com.PFE.booknetwork.services;

import com.PFE.booknetwork.dto.ProblematiqueDto;

import java.util.List;

public interface ProblematiqueService {

    ProblematiqueDto save(ProblematiqueDto dto);

    ProblematiqueDto findById(Integer id);



    List<ProblematiqueDto> findAll();

    void delete(Integer id);

}
