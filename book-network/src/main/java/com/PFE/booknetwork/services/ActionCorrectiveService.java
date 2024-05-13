package com.PFE.booknetwork.services;

import com.PFE.booknetwork.dto.ActionCorrectiveDto;
import com.PFE.booknetwork.dto.ProjetDto;

import java.util.List;

public interface ActionCorrectiveService {

   ActionCorrectiveDto save(ActionCorrectiveDto dto);

    ActionCorrectiveDto findById(Integer id);
    ActionCorrectiveDto findByPriorite(String Priorite);
    List<ActionCorrectiveDto> findAll();

    void delete(Integer id);
}
