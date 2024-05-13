package com.PFE.booknetwork.dto;


import com.PFE.booknetwork.model.Equipe;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class EquipeDto {
    private Integer id;
    private String NomEquipe;

    private String Description;

    @JsonIgnore
    private List<MembreDto> membres;
    @JsonIgnore
    private List<ProjetDto> projets;


    private ResponsableDto responsable;

    public static EquipeDto fromEntity(Equipe equipe){
        if (equipe == null){
            return null;

        }
        return EquipeDto.builder()
                .id(equipe.getId())
                .NomEquipe(equipe.getNomEquipe())
                .Description(equipe.getDescription())
                .build();
    }

    public static Equipe toEntity(EquipeDto equipeDto){
        if (equipeDto==null){
            return null;
        }

       Equipe equipe = new Equipe();
        equipe.setId(equipeDto.getId());
        equipe.setNomEquipe(equipeDto.getNomEquipe());
        equipe.setDescription((equipeDto.getDescription()));

        return equipe;
    }


}
