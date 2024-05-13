package com.PFE.booknetwork.services.impl;

import com.PFE.booknetwork.dto.EquipeDto;


import com.PFE.booknetwork.exception.EntityNotFoundException;
import com.PFE.booknetwork.exception.ErrorCodes;
import com.PFE.booknetwork.exception.InvalidEntityException;
import com.PFE.booknetwork.model.Equipe;

import com.PFE.booknetwork.repository.EquipeRepository;
import com.PFE.booknetwork.services.EquipeService;
import com.PFE.booknetwork.validator.EquipeValidator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EquipeServiceImpl implements EquipeService {

    private EquipeRepository equipeRepository;
    @Autowired
    public EquipeServiceImpl(
            EquipeRepository equipeRepository
    ) {
        this.equipeRepository = equipeRepository;
    }

    @Override
    public EquipeDto save(EquipeDto dto) {

       List<String> errors = EquipeValidator.validate((dto));
       if (!errors.isEmpty()){
           log.error("Equipe is not valid {}", dto);
           throw new InvalidEntityException("L'equipe n'est pas valide", ErrorCodes.EQUIPE_NOT_VALID, errors);
       }
       return EquipeDto.fromEntity(
               equipeRepository.save(
                       EquipeDto.toEntity(dto)
               )
       );
    }

    @Override
    public EquipeDto findById(Integer id) {

        if (id == null){
            log.error("Equipe ID is null");
            return null;
        }

        Optional<Equipe> equipe = equipeRepository.findById(id);
        return Optional.of(EquipeDto.fromEntity(equipe.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun equipe avec l'ID = " + id + " n'ete trouve dans la BDD",
                        ErrorCodes.EQUIPE_NOT_FOUND));
    }

    @Override
    public List<EquipeDto> findAll() {

        return equipeRepository.findAll().stream()
                .map(EquipeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Equipe ID is null");
            return;
        }
        equipeRepository.deleteById(id);

    }
}
