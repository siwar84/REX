package com.PFE.booknetwork.dto;



import com.PFE.booknetwork.model.Problematique;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Builder
@Data
public class ProblematiqueDto {

    private Integer id;
    private String Description;
    private String TypeAccident;
    private LocalDate DateAccident;
    private String NiveauGravite;
    private String CausesAccident;
    private String Priorite;

    private ProjetDto projet;

    @JsonIgnore
    private List<ActionCorrectiveDto> actionCorrectives;


    private ResponsableDto responsable;
    @JsonIgnore
    private Set<MembreDto> membres;

    public static ProblematiqueDto fromEntity(Problematique problematique){
        if (problematique == null){
            return null;
        }
        return ProblematiqueDto.builder()
                .id(problematique.getId())
                .Description(problematique.getDescription())
                .TypeAccident(problematique.getTypeAccident())
                .DateAccident(problematique.getDateAccident())
                .NiveauGravite(problematique.getNiveauGravite())
                .CausesAccident(problematique.getCausesAccident())
                .build();
    }

    public static Problematique toEntity(ProblematiqueDto problematiqueDto){
        if (problematiqueDto == null){
            return null;
        }
        Problematique problematique = new Problematique();
        problematique.setId(problematiqueDto.getId());
        problematique.setDescription(problematiqueDto.getDescription());
        problematique.setTypeAccident(problematiqueDto.getTypeAccident());
        problematique.setDateAccident(problematiqueDto.getDateAccident());
        problematique.setNiveauGravite(problematiqueDto.getNiveauGravite());
        problematique.setCausesAccident(problematiqueDto.getCausesAccident());
        return problematique;
    }


}
