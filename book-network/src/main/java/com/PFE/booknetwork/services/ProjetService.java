package com.PFE.booknetwork.services;

import com.PFE.booknetwork.dto.ProjetDto;

import java.util.List;

public interface ProjetService {

    ProjetDto save(ProjetDto dto);

    ProjetDto findById(Integer id);



    List<ProjetDto> findAll();

    void delete(Integer id);
}
