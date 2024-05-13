package com.PFE.booknetwork.validator;

import com.PFE.booknetwork.dto.MembreDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MembreValidators {
    public static List<String> validate(MembreDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("Veuillez renseigner le nom du membre");
            errors.add("Veuillez renseigner le Prenom du membre");
            errors.add("Veuillez renseigner la poste du membre");
            errors.add("Veuillez renseigner la numero de telephone du membre");
            errors.add("Veuillez renseigner le Mail du membre");
            return errors;


        }

        if (!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez renseigner le nom du membre");
        }
        if (!StringUtils.hasLength(dto.getPrenon())){
            errors.add("Veuillez renseigner le Prenom du membre");
        }
        if (!StringUtils.hasLength(dto.getPoste())){
            errors.add("Veuillez renseigner la poste du membre");
        }
        if (!StringUtils.hasLength(dto.getNumeroTelephone())){
            errors.add("Veuillez renseigner la numero de telephone du membre");
        }
        if (!StringUtils.hasLength(dto.getEmail())){
            errors.add("Veuillez renseigner le Mail du membre");
        }

        if (dto.getEquipe() == null){
            errors.add("Veuillez sélectionner une equipe pour le membre");
        }


        if (dto.getDepartement() == null){
            errors.add("Veuillez sélectionner un departement pour le membre");
        }

        return errors;

    }
}
