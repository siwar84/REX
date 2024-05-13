package com.PFE.booknetwork.validator;

import com.PFE.booknetwork.dto.ActionCorrectiveDto;
import com.PFE.booknetwork.dto.ResponsableDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ActionCorrectiveValidator {
    public static List<String> validate(ActionCorrectiveDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("Veuillez renseigner la description d'action corrective");
            errors.add("Veuillez renseigner la Date de réalisation prévue");
            errors.add("Veuillez renseigner la priorite de cette action corrective");
            errors.add("Veuillez renseigner l'impact attendu de cette action");


            return errors;
        }



        if (!StringUtils.hasLength(dto.getDescription())){
            errors.add("Veuillez renseigner la description d'action corrective");
        }

        if (dto.getDateRealisationPrevue() == null) {
            errors.add("Veuillez renseigner la Date de réalisation prévue");
        }
        if (!StringUtils.hasLength(dto.getPriorite())){
            errors.add("Veuillez renseigner la priorite de cette action corrective");
        }

        if (!StringUtils.hasLength(dto.getImpactAttendu())){
            errors.add("Veuillez renseigner l'impact attendu de cette action");
        }
        return errors;
    }
}
