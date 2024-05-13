package com.PFE.booknetwork.services.impl;


import com.PFE.booknetwork.dto.MembreDto;

import com.PFE.booknetwork.exception.EntityNotFoundException;
import com.PFE.booknetwork.exception.ErrorCodes;
import com.PFE.booknetwork.exception.InvalidEntityException;
import com.PFE.booknetwork.model.Membre;

import com.PFE.booknetwork.repository.MembreRepository;
import com.PFE.booknetwork.services.MembreService;
import com.PFE.booknetwork.validator.MembreValidators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class MembreServiceImpl implements MembreService {
    private MembreRepository membreRepository;
    @Autowired
    public MembreServiceImpl(
            MembreRepository membreRepository
    ) {
        this.membreRepository = membreRepository;
    }

    @Override
    public MembreDto save(MembreDto dto) {

        List<String> errors = MembreValidators.validate(dto);
        if (!errors.isEmpty()){
            log.error("Membre is not valid {}",dto);
            throw new InvalidEntityException("le membre n'est pas valide", ErrorCodes.MEMBRE_NOT_VALID, errors);
        }
        return MembreDto.fromEntity(
                membreRepository.save(
                        MembreDto.toEntity(dto)
                )
        );
    }

    @Override
    public MembreDto findById(Integer id) {

        if (id == null){
            log.error("Membre ID is null");
            return null;
        }

        Optional<Membre> membre = membreRepository.findById(id);
        return Optional.of(MembreDto.fromEntity(membre.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun membre avec l'ID = " + id + " n'ete trouve dans la BDD",
                        ErrorCodes.MEMBRE_NOT_FOUND));
    }

    @Override
    public List<MembreDto> findAll() {

        return membreRepository.findAll().stream()
                .map(MembreDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Membre ID is null");
            return;
        }
        membreRepository.deleteById(id);

    }
}
