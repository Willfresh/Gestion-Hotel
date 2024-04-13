package com.defi.tp_vente.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private int contact;
    @ManyToOne
    @JoinColumn(name= "catClientId",insertable = false, updatable = false)
    CatClient catClient;
    int catClientId;
}
