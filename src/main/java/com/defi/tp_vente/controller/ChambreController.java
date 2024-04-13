package com.defi.tp_vente.controller;

import com.defi.tp_vente.modele.Article;
import com.defi.tp_vente.modele.Chambre;
import com.defi.tp_vente.modele.Reservation;
import com.defi.tp_vente.modele.Vente;
import com.defi.tp_vente.service.CatChambreService;
import com.defi.tp_vente.service.CategorieService;
import com.defi.tp_vente.service.ChambreService;
import com.defi.tp_vente.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ChambreController {
    @Autowired
    private CatChambreService catChambreService;
    @Autowired
    private ChambreService chambreService;
    @Autowired
    private ReservationService reservationService;


    @GetMapping("/chambreShow")
    public String showAllChambre(Model model) {
        List<Chambre> listeChambres = chambreService.showAllChambre();
        List<Reservation> listeReservations = reservationService.showAllReser();
        model.addAttribute("listeChambre", chambreService.changerEtatChambre(listeChambres, listeReservations));
        return "admin/ListeChambre";
    }
    @GetMapping("/chambresLibres")
    public String showChambresLibres(Model model) {
        List<Chambre> chambresLibres = chambreService.chambresLibres(chambreService.showAllChambre(), reservationService.showAllReser());
        model.addAttribute("chambresLibres", chambresLibres);
        return "admin/listeChambreLibre";
    }
    @GetMapping("/chambresOccupees")
    public String showChambresOccupees(Model model) {
        List<Chambre> chambresOccupees = chambreService.chambresOccupees(chambreService.showAllChambre(), reservationService.showAllReser());
        model.addAttribute("chambresOccupees", chambresOccupees);
        return "admin/listeChambreOccupe";
    }

    @GetMapping("/chambreForm")
    public String ShowFormArticle(Model model){
        model.addAttribute("listeCatCham",catChambreService.showAllCatCham());
        model.addAttribute("listePrix",catChambreService.showAllPrix());
        return "admin/FormChambre";
    }
    @PostMapping("/chambre/save")
    public String saveChambre(Chambre chambre){
        chambreService.saveChambre(chambre);
        return "redirect:/chambreShow";
    }
    @GetMapping("/chambreEdit{id}")
    public String venteEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("Une_Chambre",chambreService.showOneCham(id));
        model.addAttribute("listeCatCham",catChambreService.showAllCatCham());
        model.addAttribute("listePrix",catChambreService.showAllPrix());
        return "admin/chambreEdit";
    }
    @PostMapping("chambre/update")
    public  String updateChambre(@ModelAttribute("chambre") Chambre chambre){
        chambreService.saveChambre(chambre);
        return "redirect:/chambreShow";

    }
    @GetMapping("/chambre/delete/{id}")
    public String deleteChambre(@PathVariable("id") int id){
        chambreService.deleteChambre(id);
        return "redirect:/chambreShow";
    }

}
