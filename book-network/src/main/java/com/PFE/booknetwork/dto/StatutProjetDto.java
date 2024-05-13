package com.PFE.booknetwork.dto;



import com.PFE.booknetwork.model.StatutProjet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class StatutProjetDto {
    private Integer id;

    private String Libelle;


    private String Description;


    private Date DateChangement;
    @JsonIgnore
    private List<ProjetDto> projets;


    public StatutProjetDto fromEntity(StatutProjet statutProjet){
        if (statutProjet == null){
            return null;
        }

        return StatutProjetDto.builder()
                .id(statutProjet.getId())
                .Libelle(statutProjet.getLibelle())
                .Description(statutProjet.getDescription())
                .DateChangement(statutProjet.getDateChangement())
                .build();

    }

    public StatutProjet toEntity(StatutProjetDto statutProjetDto){
        if (statutProjetDto == null){
            return null;
        }
        StatutProjet statutProjet = new StatutProjet();

        statutProjet.setId(statutProjet.getId());
        statutProjet.setLibelle(statutProjet.getLibelle());
        statutProjet.setDescription(statutProjet.getDescription());
        statutProjet.setDateChangement(statutProjet.getDateChangement());

        return statutProjet;
    }
}
