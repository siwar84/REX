package com.PFE.booknetwork.services;

import com.PFE.booknetwork.dto.EquipeDto;

import java.util.List;

public interface EquipeService {
    EquipeDto save(EquipeDto dto);

    EquipeDto findById(Integer id);

    List<EquipeDto> findAll();

    void delete(Integer id);
}
