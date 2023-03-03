package com.defi.tp_vente.service;

import com.defi.tp_vente.modele.Chambre;
import com.defi.tp_vente.modele.Facturation;
import com.defi.tp_vente.modele.Reservation;
import com.defi.tp_vente.modele.State;
import com.defi.tp_vente.repository.FacturationRepository;
import com.defi.tp_vente.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private FacturationRepository facturationRepository;

    public List<Reservation > showAllReser() {return reservationRepository.findAll();}

    public void saveReser(Reservation reservation){
        reservationRepository.save(reservation);
    }

    public List<Reservation> showAllNumRe() {
        return reservationRepository.findAll();
    }

    public Reservation showOneReser(int id) {return reservationRepository.findById(id).get();
    }

    public void deleteReser(int id) {reservationRepository.deleteById(id);
    }
    /*public List<Reservation> changerEtatReservation(List<Reservation> listeReservation , List<Facturation> listeFactuation) {
        for (Reservation reservation : listeReservation) {
            boolean chambreOccupee = false;
            for (Reservation reservation : listeReservations) {
                if (chambre.getId() == reservation.getChambre().getId()) {
                    chambreOccupee = true;
                    break;
                }
            }
            if (chambreOccupee) {
                chambre.setStatut(State.ETAT_OCCUPE);
            } else {
                chambre.setStatut(State.ETAT_LIBRE);
            }
        }
        return listeChambres;
    }*/
}
