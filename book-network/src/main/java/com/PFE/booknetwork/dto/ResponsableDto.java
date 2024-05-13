package com.PFE.booknetwork.dto;


import com.PFE.booknetwork.model.Responsable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponsableDto {
    private Integer id;
    private String Nom;
    private String Poste;
    private String Email;
    private String NumeroTelephone;

    @JsonIgnore
    private List<ProjetDto> projets;
    @JsonIgnore
    private List<EquipeDto> equipes;
    @JsonIgnore
    private List<ProblematiqueDto> problematiques;
    @JsonIgnore
    private List<ActionCorrectiveDto> actionCorrectives;
    private DepartementDto departement;

    public static ResponsableDto fromEntity(Responsable responsable){
        if (responsable == null){
            return null;
        }

        return ResponsableDto.builder()
                .id(responsable.getId())
                .Nom(responsable.getNom())
                .Poste(responsable.getPoste())
                .Email(responsable.getEmail())
                .NumeroTelephone(responsable.getNumeroTelephone())
                .build();
    }

    public static Responsable toEntity(ResponsableDto responsableDto){
        if (responsableDto == null) {
            return null;
        }
        Responsable responsable = new Responsable();
        responsable.setId(responsableDto.getId());
        responsable.setNom(responsableDto.getNom());
        responsable.setPoste(responsableDto.getPoste());
        responsable.setEmail(responsableDto.getEmail());
        responsable.setNumeroTelephone(responsableDto.getNumeroTelephone());
        return responsable;
    }







}
