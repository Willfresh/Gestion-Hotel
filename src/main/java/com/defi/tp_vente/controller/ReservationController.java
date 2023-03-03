package com.defi.tp_vente.controller;

import com.defi.tp_vente.modele.Chambre;
import com.defi.tp_vente.modele.Reservation;
import com.defi.tp_vente.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private CatChambreService catChambreService;
    @Autowired
    private ChambreService chambreService;
    @Autowired
    private CatClientService catClientService;
    @Autowired
    private ClientService clientService;
    @GetMapping("/reserShow")
    public String showAllReser(Model model){
        model.addAttribute("listeReser",reservationService.showAllReser());
        //pas obligé d'avoir le mm nom que le return
        return "admin/ListeReser";
    }

    @GetMapping("/reserForm")
    public String ShowFormReser(Model model){
        model.addAttribute("listeCatCham",catChambreService.showAllCatCham());
        model.addAttribute("listeNum",chambreService.showAllNum());
        model.addAttribute("listeCatClient",catClientService.showAllCatClient());
        model.addAttribute("listeNom",clientService.showAllNom());
        model.addAttribute("listePrix",catChambreService.showAllPrix());
        return "admin/FormReser";
    }
    @PostMapping("/reser/save")
    public String saveReser(Reservation reservation){
        reservation.setDateReservation(LocalDate.now());
        reservationService.saveReser(reservation);
        return "redirect:/reserShow";
    }
    @GetMapping("/reserEdit{id}")
    public String reserEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("Une_reservation",reservationService.showOneReser(id));
        model.addAttribute("listeCatCham",catChambreService.showAllCatCham());
        model.addAttribute("listeNum",chambreService.showAllNum());
        model.addAttribute("listeCatClient",catClientService.showAllCatClient());
        model.addAttribute("listeNom",clientService.showAllNom());
        model.addAttribute("listePrix",catChambreService.showAllPrix());
        return "admin/reserEdit";
    }
    @PostMapping("reser/update")
    public  String updateReser(@ModelAttribute("reservation") Reservation reservation){
        reservationService.saveReser(reservation);
        return "redirect:/reserShow";

    }
    @GetMapping("/reser/delete/{id}")
    public String deleteReser(@PathVariable("id") int id){
        reservationService.deleteReser(id);
        return "redirect:/reserShow";
    }
}
