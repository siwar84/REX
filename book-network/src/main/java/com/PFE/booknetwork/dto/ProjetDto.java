package com.PFE.booknetwork.dto;


import com.PFE.booknetwork.model.Projet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import java.util.Date;
import java.util.List;
@Data
@Builder
public class ProjetDto {

    private Integer id;
    private String TitreProjet;
    private String Description;
    private String ObjectifsProjet;
    private Date DateFabrication;
    @JsonIgnore
    private List<ProblematiqueDto> problematiques;

    private EquipeDto equipe;

    private StatutProjetDto statutProjet;

    private ResponsableDto responsable;

    public static ProjetDto fromEntity(Projet projet){
        if (projet == null){
            return null;
        }
         return ProjetDto.builder()
                 .id(projet.getId())
                 .TitreProjet(projet.getTitreProjet())
                 .Description(projet.getDescription())
                 .ObjectifsProjet(projet.getObjectifsProjet())
                 .DateFabrication(projet.getDateFabrication())
                 .build();
    }

    public static Projet toEntity(ProjetDto projetDto){
        if (projetDto == null){
            return null;
        }
        Projet projet = new Projet();
        projet.setId(projetDto.getId());
        projet.setTitreProjet(projetDto.getTitreProjet());
        projet.setDescription(projetDto.getDescription());
        projet.setObjectifsProjet(projetDto.getObjectifsProjet());
        projet.setDateFabrication(projetDto.getDateFabrication());
        return projet;
    }


}


