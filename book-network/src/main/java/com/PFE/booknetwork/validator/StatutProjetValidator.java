package com.PFE.booknetwork.validator;

import com.PFE.booknetwork.dto.EquipeDto;
import com.PFE.booknetwork.dto.ResponsableDto;
import com.PFE.booknetwork.dto.StatutProjetDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StatutProjetValidator {
    public static List<String> validate(StatutProjetDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("Veuillez renseigner le statut du projet ");
            errors.add("Veuillez renseigner la date du changement");
            return errors;
        }




        if (!StringUtils.hasLength(dto.getLibelle())) {
            errors.add("Veuillez renseigner le statut du projet ");
        }

        if (dto.getDateChangement() == null) {
            errors.add("Veuillez renseigner la date du changement");
        }


        return errors;
    }


    }
