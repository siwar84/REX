package com.PFE.booknetwork.services.impl;


import com.PFE.booknetwork.dto.ResponsableDto;
import com.PFE.booknetwork.exception.EntityNotFoundException;
import com.PFE.booknetwork.exception.ErrorCodes;
import com.PFE.booknetwork.exception.InvalidEntityException;

import com.PFE.booknetwork.model.Responsable;
import com.PFE.booknetwork.repository.ResponsableRepository;
import com.PFE.booknetwork.services.ResponsableService;

import com.PFE.booknetwork.validator.ResponsableValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ResponsableServiceImpl implements ResponsableService {
    ResponsableRepository responsableRepository;

    @Autowired
    public ResponsableServiceImpl(
            ResponsableRepository responsableRepository
    ) {
        this.responsableRepository = responsableRepository;
    }

    @Override
    public ResponsableDto save(ResponsableDto dto) {

        List<String> errors = ResponsableValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Responsable is not valid {}",dto);
            throw new InvalidEntityException("le responsable n'est pas valide", ErrorCodes.RESPONSABLE_NOT_VALID, errors);
        }
        return ResponsableDto.fromEntity(
                responsableRepository.save(
                        ResponsableDto.toEntity(dto)
                )
        );
    }

    @Override
    public ResponsableDto findById(Integer id) {
        if (id == null){
            log.error("Responsable ID is null");
            return null;
        }

        Optional<Responsable> responsable = responsableRepository.findById(id);
        return Optional.of(ResponsableDto.fromEntity(responsable.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun responsable avec l'ID = " + id + " n'ete trouve dans la BDD",
                        ErrorCodes.RESPONSABLE_NOT_FOUND));
    }

    @Override
    public List<ResponsableDto> findAll() {

        return responsableRepository.findAll().stream()
                .map(ResponsableDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Responsable ID is null");
            return;
        }
        responsableRepository.deleteById(id);

    }
}
