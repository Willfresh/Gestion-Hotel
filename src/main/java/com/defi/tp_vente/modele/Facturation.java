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
public class Facturation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int montant;
    @DateTimeFormat(pattern = "yyyy/MM/dd")//format de la date (valable juste en dessous)
    private LocalDate dateFacturation;
    @ManyToOne
    @JoinColumn(name= "reservationId",insertable = false, updatable = false)
    private Reservation reservation;
    private int reservationId;

    @ManyToOne
    @JoinColumn(name= "clientId",insertable = false, updatable = false)
    private Client client;
    private int clientId;

    @ManyToOne
    @JoinColumn(name= "chambreId",insertable = false, updatable = false)
    private Chambre chambre;
    private int chambreId;
    @ManyToOne
    @JoinColumn(name= "catChambreId",insertable = false, updatable = false)
    private CatChambre catChambre;
    private int catChambreId;
}
