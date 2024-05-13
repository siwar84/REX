package com.PFE.booknetwork.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "équipe")
public class Equipe extends AbstractEntity{

    @Column(name = "nomequipe")
    private String NomEquipe;

    @Column(name = "description")
    private String Description;

    @OneToMany(mappedBy = "equipe")
    private List<Membre> membres;

    @OneToMany(mappedBy = "equipe")
    private List<Projet> projets;

    @ManyToOne
    @JoinColumn(name = "idresponsable")
    private Responsable responsable;
}
