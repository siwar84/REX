package com.PFE.booknetwork.services;

import com.PFE.booknetwork.dto.MembreDto;


import java.util.List;

public interface MembreService {
    MembreDto save(MembreDto dto);

    MembreDto findById(Integer id);


    List<MembreDto> findAll();

    void delete(Integer id);
}
