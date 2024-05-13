package com.PFE.booknetwork.services.impl;

import com.PFE.booknetwork.dto.ProblematiqueDto;

import com.PFE.booknetwork.exception.EntityNotFoundException;
import com.PFE.booknetwork.exception.ErrorCodes;
import com.PFE.booknetwork.exception.InvalidEntityException;
import com.PFE.booknetwork.model.Problematique;

import com.PFE.booknetwork.repository.ProblematiqueRepository;
import com.PFE.booknetwork.services.ProblematiqueService;
import com.PFE.booknetwork.validator.ProblematiqueValidator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProblematiqueServiceImpl implements ProblematiqueService {


    private ProblematiqueRepository problematiqueRepository;
    @Autowired
    public ProblematiqueServiceImpl(
            ProblematiqueRepository problematiqueRepository
    ) {
        this.problematiqueRepository =problematiqueRepository;
    }

    @Override
    public ProblematiqueDto save(ProblematiqueDto dto){
    List<String> errors = ProblematiqueValidator.validate(dto);
        if (!errors.isEmpty()){
        log.error("Problematique is not valid {}",dto);
        throw new InvalidEntityException("le problematique n'est pas valide", ErrorCodes.PROBLEMATIQUE_NOT_VALID, errors);
    }
         return ProblematiqueDto.fromEntity(
                 problematiqueRepository.save(
                 ProblematiqueDto.toEntity(dto)
            )
            );
    }

    @Override
    public ProblematiqueDto findById(Integer id) {
        if (id == null){
            log.error("Problematique ID is null");
            return null;
        }

        Optional<Problematique> problematique = problematiqueRepository.findById(id);
        return Optional.of(ProblematiqueDto.fromEntity(problematique.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun problematique avec l'ID = " + id + " n'ete trouve dans la BDD",
                        ErrorCodes.PROBLEMATIQUE_NOT_FOUND));
    }

    @Override
    public List<ProblematiqueDto> findAll() {
        return problematiqueRepository.findAll().stream()
                .map(ProblematiqueDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Problematique ID is null");
            return;
        }
        problematiqueRepository.deleteById(id);

    }
}
