package com.defi.tp_vente.controller;

import com.defi.tp_vente.modele.Facturation;
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
public class FacturationController {
    @Autowired
    private FacturationService facturationService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private CatChambreService catChambreService;
    @Autowired
    private ChambreService chambreService;
    @GetMapping("/factShow")
    public String showAllFact(Model model){
        model.addAttribute("listeFact",facturationService.showAllFact());
        //pas obligé d'avoir le mm nom que le return
        return "admin/ListeFact";
    }

    @GetMapping("/factForm")
    public String ShowFormFact(Model model){
        model.addAttribute("listeNumRe",reservationService.showAllNumRe());
        model.addAttribute("listeNom",clientService.showAllNom());
        model.addAttribute("listeNum",chambreService.showAllNum());
        model.addAttribute("listePrix",catChambreService.showAllPrix());
        return "admin/FormFact";
    }
    @PostMapping("/fact/save")
    public String saveFact(Facturation facturation){
        facturation.setDateFacturation(LocalDate.now());
        facturationService.saveFact(facturation);
        return "redirect:/factShow";
    }
    @GetMapping("/factEdit{id}")
    public String reserEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("Une_facturation",facturationService.showOneFact(id));
        model.addAttribute("listeNumRe",reservationService.showAllNumRe());
        model.addAttribute("listeNom",clientService.showAllNom());
        model.addAttribute("listeNum",chambreService.showAllNum());
        model.addAttribute("listePrix",catChambreService.showAllPrix());
        return "admin/factEdit";
    }
    @PostMapping("fact/update")
    public  String updateFact(@ModelAttribute("facturation") Facturation facturation){
        facturationService.saveFact(facturation);
        return "redirect:/factShow";

    }
    @GetMapping("/fact/delete/{id}")
    public String deleteReser(@PathVariable("id") int id){
        facturationService.deleteFact(id);
        return "redirect:/factShow";
    }
}
