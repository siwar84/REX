package com.PFE.booknetwork.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "problematique")
public class Problematique extends AbstractEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "typeaccident")
    private String typeAccident;

    @Column(name = "dateAccident")
    private LocalDate dateAccident;

    @Column(name = "niveaugravite")
    private String niveauGravite;

    @Column(name = "causeaccident")
    private String causesAccident;

    @Column(name = "priorite")
    private String priorite;

    @ManyToOne
    @JoinColumn(name = "idprojet")
    private Projet projet;

    @OneToMany(mappedBy = "problematique")
    private List<ActionCorrective> actionCorrectives;

    @ManyToOne
    @JoinColumn(name = "idresponsable")
    private Responsable responsable;

    @ManyToMany(mappedBy = "problematiques")
    private Set<Membre> membres = new HashSet<>();
}
