package com.PFE.booknetwork.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "membre")
public class Membre extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "poste")
    private String poste;

    @Column(name = "numerotelephone")
    private String numeroTelephone;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "idequipe")
    private Equipe equipe;

    @ManyToOne
    @JoinColumn(name = "iddepartement")
    private Departement departement;

    @ManyToMany
    @JoinTable(name = "problematique_membre",
            joinColumns = @JoinColumn(name = "membre_id"),
            inverseJoinColumns = @JoinColumn(name = "problematique_id"))
    private Set<Problematique> problematiques = new HashSet<>();
}
