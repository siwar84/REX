package com.PFE.booknetwork.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "statutproduit")
public class StatutProjet extends AbstractEntity {

    @Column(name = "libelle")
    private String Libelle;

    @Column(name = "description")
    private String Description;

    @Column(name = "datechangement")
    private Date DateChangement;

    @Column(name = "responsablechangement")
    private String ResponsableChangement;

    @OneToMany(mappedBy = "statutProjet")
    private List<Projet> projets;
}
