package com.PFE.booknetwork.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "responsable")
public class Responsable extends AbstractEntity{

    @Column(name = "nom")
    private String nom;

    @Column(name = "poste")
    private String poste;

    @Column(name = "email")
    private String email;

    @Column(name = "numerotelephone")
    private String numeroTelephone;

    @OneToMany(mappedBy = "responsable")
    private List<Projet> projets;

    @OneToMany(mappedBy = "responsable")
    private List<Equipe> equipes;

    @OneToMany(mappedBy = "responsable")
    private List<Problematique> problematiques;

    //@OneToMany(mappedBy = "responsable")
    //private List<ActionCorrective> actionCorrectives;

    @OneToOne(mappedBy = "responsable", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Departement departement;
}

