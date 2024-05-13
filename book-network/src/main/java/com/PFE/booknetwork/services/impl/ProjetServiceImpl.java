package com.PFE.booknetwork.services.impl;

import com.PFE.booknetwork.dto.ProjetDto;
import com.PFE.booknetwork.exception.EntityNotFoundException;
import com.PFE.booknetwork.exception.ErrorCodes;
import com.PFE.booknetwork.exception.InvalidEntityException;
import com.PFE.booknetwork.model.Projet;
import com.PFE.booknetwork.repository.ProjetRepository;
import com.PFE.booknetwork.services.ProjetService;
import com.PFE.booknetwork.validator.ProjetValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProjetServiceImpl implements ProjetService {
    private ProjetRepository projetRepository;

    @Autowired
    public ProjetServiceImpl(
            ProjetRepository projetRepository
    ) {
        this.projetRepository = projetRepository;
    }

    @Override
    public ProjetDto findById(Integer id) {
        if (id == null){
            log.error("Projet ID is null");
            return null;
        }

        Optional<Projet> projet = projetRepository.findById(id);
        return Optional.of(ProjetDto.fromEntity(projet.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun projet avec l'ID = " + id + " n'ete trouve dans la BDD",
                        ErrorCodes.PROJECT_NOT_FOUND));
    }



    @Override
    public List<ProjetDto> findAll() {
        return projetRepository.findAll().stream()
                .map(ProjetDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Projet ID is null");
            return;
        }
        projetRepository.deleteById(id);

    }

    @Override
    public ProjetDto save(ProjetDto dto) {
        List<String> errors = ProjetValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Projet is not valid {}",dto);
            throw new InvalidEntityException("le projet n'est pas valide", ErrorCodes.PROJECT_NOT_VALID, errors);
        }
         return ProjetDto.fromEntity(
                projetRepository.save(
                       ProjetDto.toEntity(dto)
                )
        );
    }
}
