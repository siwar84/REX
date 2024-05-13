package com.PFE.booknetwork.dto;




import com.PFE.booknetwork.model.Departement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class DepartementDto {
    private Integer id;
    private String NomDepartement;

    @JsonIgnore
    private List<MembreDto> membres;


    private ResponsableDto responsable;

    public DepartementDto fromEntity(Departement departement){
        if (departement == null){
            return null;
        }

        return DepartementDto.builder()
                .id(departement.getId())
                .NomDepartement(departement.getNomDepartement())
                .build();

    }

    public Departement toEntity(DepartementDto departementDto){
        if (departementDto == null){
            return null;
        }

        Departement departement =new Departement();
        departement.setId(departementDto.getId());
        departement.setNomDepartement(departementDto.getNomDepartement());
        return departement;
    }




}
