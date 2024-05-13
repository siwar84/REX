package com.PFE.booknetwork.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "actioncorrective")
public class ActionCorrective extends AbstractEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "dateproposition")
    private Date dateProposition;

    @Column(name = "daterealisationprevue")
    private Date dateRealisationPrevue;

    @Column(name = "priorite")
    private String priorite;

    @Column(name = "statutaction")
    private String statutAction;

    @Column(name = "impactattendu")
    private String impactAttendu;

    @ManyToOne
    @JoinColumn(name = "idproblematique")
    private Problematique problematique;

    // Remove @ManyToOne relation with Membre and Responsable
}
