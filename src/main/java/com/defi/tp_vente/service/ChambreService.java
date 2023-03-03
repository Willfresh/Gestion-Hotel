package com.defi.tp_vente.service;

import com.defi.tp_vente.modele.Chambre;
import com.defi.tp_vente.modele.Reservation;
import com.defi.tp_vente.modele.State;
import com.defi.tp_vente.repository.ChambreRepository;
import com.defi.tp_vente.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreService {
    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    public void saveChambre(Chambre chambre){
        chambreRepository.save(chambre);
    }

    public List<Chambre> showAllChambre(){
        return chambreRepository.findAll();
    }


    public List<Chambre> showAllNum() {return chambreRepository.findAll();
    }

    public Chambre showOneCham(int id) { return chambreRepository.findById(id).get();}

    public void deleteChambre(int id) {chambreRepository.deleteById(id);
    }

    /*public List<Chambre> changerEtatChambre(List<Chambre> listeChambres) {
        for (Chambre chambre : listeChambres) {
            boolean chambreOccupee = false;
            if (chambre.getNumeroChambre() == chambre.getCatChambreId()) {
                chambreOccupee = true;
                break;
            }
            else if (chambreOccupee) {
                chambre.setStatut(State.ETAT_OCCUPE);
            }
            else {
                chambre.setStatut(State.ETAT_LIBRE);
            }
        }
        return listeChambres;
    }*/
    public List<Chambre> changerEtatChambre(List<Chambre> listeChambres, List<Reservation> listeReservations) {
        for (Chambre chambre : listeChambres) {
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
    }


}
