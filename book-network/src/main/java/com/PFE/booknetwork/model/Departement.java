package com.PFE.booknetwork.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "departement")
public class Departement extends AbstractEntity {

    @Column(name = "nomdepartement" )
    private String NomDepartement;


    @OneToMany(mappedBy = "departement")
    private List<Membre> membres;

    @OneToOne
    @MapsId
    @JoinColumn(name = "responsable_id")
    private Responsable responsable;
}
