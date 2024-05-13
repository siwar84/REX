package com.PFE.booknetwork.validator;


import com.PFE.booknetwork.dto.ResponsableDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ResponsableValidator {

    public static List<String> validate(ResponsableDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("Veuillez renseigner le nom du responsable");
            errors.add("Veuillez renseigner la poste du responsable");
            errors.add("Veuillez renseigner le mail du responsable");
            errors.add("Veuillez renseigner le numero telephone du responsable");

            errors.add("Veuillez sélectionner un departement de responsable");

            return errors;
        }



        if (!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez renseigner le nom du responsable");
        }

        if (!StringUtils.hasLength(dto.getPoste())){
            errors.add("Veuillez renseigner la poste du responsable");
        }

        if (!StringUtils.hasLength(dto.getEmail())){
            errors.add("Veuillez renseigner le mail du responsable");
        }

        if (!StringUtils.hasLength(dto.getNumeroTelephone())){
            errors.add("Veuillez renseigner le numero telephone du responsable");
        }
        if (dto.getDepartement() == null){
            errors.add("Veuillez sélectionner un departement de responsable");
        }


        return errors;
    }
}
