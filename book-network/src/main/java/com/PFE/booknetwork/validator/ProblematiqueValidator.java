package com.PFE.booknetwork.validator;

import com.PFE.booknetwork.dto.ProblematiqueDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProblematiqueValidator {

    public static List<String> validate(ProblematiqueDto dto){
        List<String> errors = new ArrayList<>();

        if (!StringUtils.hasLength(dto.getDescription())){
            errors.add("Veuillez renseigner une description de la problematique");
        }

        if (!StringUtils.hasLength(dto.getTypeAccident())){
            errors.add("Veuillez renseigner un type de l'accident");
        }
        if (!StringUtils.hasLength(dto.getTypeAccident())){
            errors.add("Veuillez renseigner un type de l'accident");
        }

        if (dto.getDateAccident() == null) {
            errors.add("Veuillez renseigner la date de l'accident");
        }

        if (!StringUtils.hasLength(dto.getNiveauGravite())){
            errors.add("Veuillez renseigner le niveau de gravite de l'accident");
        }

        if (!StringUtils.hasLength(dto.getPriorite())){
            errors.add("Veuillez renseigner la priorite de problematique");
        }

        if (dto.getProjet() == null){
            errors.add("Veuillez sélectionner le projet où il y a un problème");
        }

        if (dto.getResponsable() == null){
            errors.add("Veuillez sélectionner le responsable de la problématique");
        }






        return errors;
    }


}
