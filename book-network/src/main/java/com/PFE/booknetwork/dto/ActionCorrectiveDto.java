package com.PFE.booknetwork.dto;


import com.PFE.booknetwork.model.ActionCorrective;
import lombok.Builder;
import lombok.Data;
import java.util.Date;
import java.util.Set;

@Data
@Builder

public class ActionCorrectiveDto {
    private Integer id;
    private String Description;





    private Date DateProposition;


    private Date DateRealisationPrevue;


    private String Priorite;


    private String StatutAction;


    private String ImpactAttendu;


    private ProblematiqueDto problematique;


    private MembreDto membre;

    public static ActionCorrectiveDto fromEntity(ActionCorrective actionCorrective){
        if (actionCorrective == null){
            return null;
        }

        return ActionCorrectiveDto.builder()
                .id(actionCorrective.getId())
                .Description(actionCorrective.getDescription())

                .DateProposition(actionCorrective.getDateProposition())
                .DateRealisationPrevue(actionCorrective.getDateRealisationPrevue())
                .Priorite(actionCorrective.getPriorite())
                .StatutAction(actionCorrective.getStatutAction())
                .ImpactAttendu(actionCorrective.getImpactAttendu())
                .build();
    }

    public static ActionCorrective toEntity(ActionCorrectiveDto actionCorrectiveDto){
        if (actionCorrectiveDto == null) {
            return null;
        }
        ActionCorrective actionCorrective = new ActionCorrective();
        actionCorrective.setId(actionCorrectiveDto.getId());
        actionCorrective.setDescription(actionCorrectiveDto.getDescription());

        actionCorrective.setDateProposition(actionCorrectiveDto.getDateProposition());
        actionCorrective.setDateRealisationPrevue(actionCorrectiveDto.getDateRealisationPrevue());
        actionCorrective.setPriorite(actionCorrectiveDto.getPriorite());
        actionCorrective.setStatutAction(actionCorrectiveDto.getStatutAction());
        actionCorrective.setImpactAttendu(actionCorrectiveDto.getImpactAttendu());
        return actionCorrective;
    }




}
