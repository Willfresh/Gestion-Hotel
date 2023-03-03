package com.defi.tp_vente.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatChambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String typeChambre;
    private int prix;


}
