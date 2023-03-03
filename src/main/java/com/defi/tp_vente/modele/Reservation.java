package com.defi.tp_vente.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int montant;
    @DateTimeFormat(pattern = "yyyy/MM/dd")//format de la date (valable juste en dessous)
    private LocalDate dateReservation;
    private String duree;
    @Transient
    private String statut;
    @ManyToOne
    @JoinColumn(name= "catClientId",insertable = false, updatable = false)
    CatClient catClient;
    int catClientId;

    @ManyToOne
    @JoinColumn(name= "clientId",insertable = false, updatable = false)
    private Client client;
    private int clientId;

    @ManyToOne
    @JoinColumn(name= "catChambreId",insertable = false, updatable = false)
    private CatChambre catChambre;
    private int catChambreId;

    @ManyToOne
    @JoinColumn(name= "chambreId",insertable = false, updatable = false)
    private Chambre chambre;
    private int chambreId;

}
