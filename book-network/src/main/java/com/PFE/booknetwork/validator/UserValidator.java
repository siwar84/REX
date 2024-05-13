package com.PFE.booknetwork.validator;

import com.PFE.booknetwork.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UserDto userDto){
        List<String> errors = new ArrayList<>();

        if (userDto == null){
            errors.add("Veuillez renseigner le matricule");
            errors.add("Veuillez renseigner le nom");
            errors.add("Veuillez renseigner le prenon");
            errors.add("Veuillez renseigner le mail");
            errors.add("Veuillez renseigner la date de naissance");
            errors.add("Veuillez renseigner le mot de passe");
            return errors;
        }


        if (!StringUtils.hasLength(userDto.getMatricule())){
            errors.add("Veuillez renseigner le matricule");
        }
        if (!StringUtils.hasLength(userDto.getFirstname())){
            errors.add("Veuillez renseigner le nom");
        }
        if (!StringUtils.hasLength(userDto.getLastname())){
            errors.add("Veuillez renseigner le prenon");
        }
        if (!StringUtils.hasLength(userDto.getEmail())){
            errors.add("Veuillez renseigner le mail");
        }
        if (userDto.getDateOfBirth()==null){
            errors.add("Veuillez renseigner la date de naissance");
        }
        if (!StringUtils.hasLength(userDto.getPassword())){
            errors.add("Veuillez renseigner le mot de passe");
        }

        return errors;
    }
}
