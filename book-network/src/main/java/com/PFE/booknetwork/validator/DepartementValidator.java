package com.PFE.booknetwork.validator;

import com.PFE.booknetwork.dto.DepartementDto;
import com.PFE.booknetwork.dto.MembreDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DepartementValidator {
    public static List<String> validate(DepartementDto dto){
        List<String> errors = new ArrayList<>();
        if (dto == null){
            errors.add("Veuillez renseigner le nom du departement");
            return errors;
        }



        if (!StringUtils.hasLength(dto.getNomDepartement())){
            errors.add("Veuillez renseigner le nom du departement");
        }


        return errors;
}
}

