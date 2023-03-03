package com.defi.tp_vente.controller;

import com.defi.tp_vente.modele.CatChambre;
import com.defi.tp_vente.modele.Categorie;
import com.defi.tp_vente.service.CatChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CatChambreController {
    @Autowired
    private CatChambreService catChambreService;
    @GetMapping("/catChamShow")
    public String showAllCatCham(Model model){
        model.addAttribute("listeCatCham",catChambreService.showAllCatCham());
        //pas obligé d'avoir le mm nom que le return
        return "admin/ListeCatCham";
    }
    @GetMapping("/catChamForm")
    public String showFormCatCham(){
        return "admin/FormCatCham";
    }
    @PostMapping("/catCham/save")
    public String saveCatCham(CatChambre catChambre){
        catChambreService.saveCatCham(catChambre);
        return "redirect:/catChamShow";
    }

}
