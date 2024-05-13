package com.PFE.booknetwork.validator;

import com.PFE.booknetwork.dto.ProjetDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProjetValidator {
    public static List<String> validate(ProjetDto projetDto){
        List<String> errors = new ArrayList<>();
        if (projetDto== null){
            errors.add("Veuillez renseigner un titre pour votre projet");
            errors.add("Veuillez renseigner la date de fabrication");
            errors.add("Veuillez sélectionner un statut pour le projet");
            errors.add("Veuillez sélectionner une équipe de travail");
            errors.add("Veuillez sélectionner un responsable de projet");
            return errors;

        }

        if (!StringUtils.hasLength(projetDto.getTitreProjet())){
            errors.add("Veuillez renseigner un titre pour votre projet");
        }
        if (projetDto.getDateFabrication() == null){
            errors.add("Veuillez renseigner la date de fabrication");
        }

        if (projetDto.getStatutProjet() == null){
            errors.add("Veuillez sélectionner un statut pour le projet");
        }

        if (projetDto.getEquipe() == null){
            errors.add("Veuillez sélectionner une équipe de travail");
        }

        if (projetDto.getResponsable() == null){
            errors.add("Veuillez sélectionner un responsable de projet");
        }



        return errors;

    }
}
