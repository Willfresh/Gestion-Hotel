package com.defi.tp_vente.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numeroChambre;
    @Transient
    private String statut;
    @ManyToOne
    @JoinColumn(name= "catChambreId",insertable = false, updatable = false)
    private CatChambre catChambre;
    private int catChambreId;

}
