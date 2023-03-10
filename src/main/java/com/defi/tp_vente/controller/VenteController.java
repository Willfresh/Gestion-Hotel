package com.defi.tp_vente.controller;

import com.defi.tp_vente.modele.Vente;
import com.defi.tp_vente.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class VenteController {
    @Autowired
    private VenteService venteService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ClientService clientService;

    @Autowired
    private ChambreService chambreService;

    @GetMapping("/venteShow")
    public String showAllVente(Model model){
        model.addAttribute("listeVente",venteService.showAllVente());
        //pas obligé d'avoir le mm nom que le return
        return "admin/ListeVente";
    }
    @GetMapping("/venteForm")
    public String ShowFormVente(Model model){
        model.addAttribute("listeVente",articleService.showAllArticles());
        model.addAttribute("listeNom",clientService.showAllNom());
        model.addAttribute("listeNum",chambreService.showAllNum());
        return "admin/FormVente";
    }
    @PostMapping("/vente/save")
    public String saveVente(Vente vente){
        vente.setQteVente(vente.getQteVente());
        vente.setDateVente(LocalDate.now());
        venteService.saveVente(vente);
        articleService.degrade(vente.getQteVente(),vente.getArticleId());
        return "redirect:/venteShow";
    }
    @GetMapping("/venteEdit{id}")
    public String venteEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("Une_vente",venteService.showOnevente(id));
        model.addAttribute("listeVente",articleService.showAllArticles());
        model.addAttribute("listeNom",clientService.showAllNom());
        model.addAttribute("listeNum",chambreService.showAllNum());

        return "admin/venteEdit";
    }
    @PostMapping("vente/update")
    public  String updateVente(@ModelAttribute("vente") Vente vente){
        venteService.saveVente(vente);
        return "redirect:/venteShow";

    }
    @GetMapping("/vente/delete/{id}")
    public String deleteVente(@PathVariable("id") int id){
        venteService.deleteVente(id);
        return "redirect:/venteShow";
    }
    @GetMapping("/qte/vente")
    public String ListeVente(Model model, @RequestParam int qteVente){
        model.addAttribute("listeByQteVente",venteService.findByQuantiteVente(qteVente));
        return "/admin/ListeQteVente";
    }

    @PostMapping("/vente/qteVente")
    public String listeByname(@RequestParam int qte){
        venteService.findByQuantiteVente(qte);
        return "redirect:/qte/vente";
    }

}
