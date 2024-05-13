package com.PFE.booknetwork.dto;



import com.PFE.booknetwork.model.Membre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import java.util.Set;

@Data
@Builder
public class MembreDto {

    private Integer id;
    private String Nom;


    private String Prenon;


    private String Poste;


    private  String NumeroTelephone;



    private  String Email;


    private EquipeDto equipe;


    private DepartementDto departement;
    @JsonIgnore
    private Set<ProblematiqueDto> problematiques ;
    @JsonIgnore
    private Set<ActionCorrectiveDto> actionCorrectives;

    public static MembreDto fromEntity(Membre membre){
        if (membre == null){
            return null;
        }
        return MembreDto.builder()
                .id(membre.getId())
                .Nom(membre.getNom())
                .Prenon(membre.getPrenom())
                .Poste(membre.getPoste())
                .NumeroTelephone(membre.getNumeroTelephone())
                .Email(membre.getEmail())
                .build();
    }

    public static Membre toEntity(MembreDto membreDto){
        if (membreDto == null){
            return null;
        }
        Membre membre = new Membre();
        membre.setId(membreDto.getId());
        membre.setNom(membreDto.getNom());
        membre.setPrenom(membreDto.getPrenon());
        membre.setPoste(membreDto.getPoste());
        membre.setNumeroTelephone(membreDto.getNumeroTelephone());
        membre.setEmail(membreDto.getEmail());
        return membre;
    }

}
