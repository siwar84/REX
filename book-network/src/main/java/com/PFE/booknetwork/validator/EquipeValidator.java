package com.PFE.booknetwork.validator;

import com.PFE.booknetwork.dto.EquipeDto;
import com.PFE.booknetwork.dto.MembreDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EquipeValidator {

    public static List<String> validate(EquipeDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("Veuillez renseigner le nom d'equipe");
            errors.add("Veuillez sélectionner un responsable de l'equipe");
            return errors;

        }


        if (!StringUtils.hasLength(dto.getNomEquipe())) {
            errors.add("Veuillez renseigner le nom d'equipe");
        }


        if (dto.getResponsable() == null) {
            errors.add("Veuillez sélectionner un responsable de l'equipe");
        }


        return errors;
    }
}
