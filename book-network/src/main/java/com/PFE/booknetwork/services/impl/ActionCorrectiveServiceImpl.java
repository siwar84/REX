package com.PFE.booknetwork.services.impl;

import com.PFE.booknetwork.dto.ActionCorrectiveDto;
import com.PFE.booknetwork.exception.EntityNotFoundException;
import com.PFE.booknetwork.exception.ErrorCodes;
import com.PFE.booknetwork.exception.InvalidEntityException;
import com.PFE.booknetwork.model.ActionCorrective;
import com.PFE.booknetwork.model.Membre;
import com.PFE.booknetwork.model.Problematique;
import com.PFE.booknetwork.repository.ActionCorrectiveRepository;
import com.PFE.booknetwork.repository.MembreRepository;
import com.PFE.booknetwork.repository.ProblematiqueRepository;
import com.PFE.booknetwork.services.ActionCorrectiveService;
import com.PFE.booknetwork.validator.ActionCorrectiveValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class ActionCorrectiveServiceImpl implements ActionCorrectiveService {

    private ActionCorrectiveRepository actionCorrectiveRepository;
    private MembreRepository membreRepository;
    private ProblematiqueRepository problematiqueRepository;

    @Autowired
    public ActionCorrectiveServiceImpl(ActionCorrectiveRepository actionCorrectiveRepository,
                                       MembreRepository membreRepository, ProblematiqueRepository problematiqueRepository) {
        this.actionCorrectiveRepository = actionCorrectiveRepository;
        this.membreRepository = membreRepository;
        this.problematiqueRepository = problematiqueRepository;
    }

    @Override
    public ActionCorrectiveDto save(ActionCorrectiveDto dto) {
        List<String> errors = ActionCorrectiveValidator.validate(dto);

        if (!errors.isEmpty()){
            log.error("Action corrective n'est pas valide");
            throw new InvalidEntityException(" l'action corrective n'est pas valide", ErrorCodes.ACTIONCORRECTIVE_NOT_VALID, errors);
        }
        Optional<Membre> membre = membreRepository.findById(dto.getMembre().getId());
        if (!membre.isPresent()){
            log.warn("Membre with ID {} was not found in the DB",dto.getMembre().getId());
            throw new EntityNotFoundException("Aucun membre avec l'ID " + dto.getMembre().getId() +" n'ete trouve dans la BDD",ErrorCodes.MEMBRE_NOT_FOUND);
        }
        Optional<Problematique> problematique = problematiqueRepository.findById(dto.getProblematique().getId());
        if (problematique.isEmpty()){
            log.warn("problematique with ID {} was not found in the DB",dto.getProblematique().getId());
            throw new EntityNotFoundException("Aucun membre avec l'ID " + dto.getProblematique().getId() +" n'ete trouve dans la BDD",ErrorCodes.MEMBRE_NOT_FOUND);

        }
        ActionCorrective savedActionCorrective = actionCorrectiveRepository.save(ActionCorrectiveDto.toEntity(dto));
        return null;
    }

    @Override
    public ActionCorrectiveDto findById(Integer id) {
        return null;
    }

    @Override
    public ActionCorrectiveDto findByPriorite(String Priorite) {
        return null;
    }

    @Override
    public List<ActionCorrectiveDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
