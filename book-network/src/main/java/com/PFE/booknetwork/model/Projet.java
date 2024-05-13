package com.PFE.booknetwork.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "projet")
public class Projet extends AbstractEntity {

    @Column(name = "titreprojet")
    private String TitreProjet;

    @Column(name = "description")
    private String Description;

    @Column(name = "objectifsprojet")
    private String ObjectifsProjet;

    @Column(name = "datefabrication")
    private Date DateFabrication;

    @OneToMany(mappedBy = "projet")
    private List<Problematique> problematiques;

    @ManyToOne
    @JoinColumn(name = "idequipe")
    private Equipe equipe;

    @ManyToOne
    @JoinColumn(name = "idstatutprojet")
    private StatutProjet statutProjet;


    @ManyToOne
    @JoinColumn(name = "idresponsable")
    private Responsable responsable;
}
