package com.defi.tp_vente.service;

import com.defi.tp_vente.modele.*;
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
    public List<Reservation> changerEtatReservation(List<Reservation> listeReservation , List<Facturation> listeFacturation) {
        for (Reservation reservation : listeReservation) {
            boolean reserPayee = false;
            for (Facturation facturation : listeFacturation) {
                if (reservation.getId() == facturation.getChambre().getId()) {
                    reserPayee = true;
                    break;
                }
            }
            if (reserPayee) {
                reservation.setStatut(Etat.ETAT_PAYE);
            } else {
                reservation.setStatut(Etat.ETAT_LIBRE);
            }
        }
        return listeReservation;
    }
}
