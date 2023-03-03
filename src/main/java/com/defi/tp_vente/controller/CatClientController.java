package com.defi.tp_vente.controller;

import com.defi.tp_vente.modele.CatChambre;
import com.defi.tp_vente.modele.CatClient;
import com.defi.tp_vente.service.CatClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CatClientController {
    @Autowired
    private CatClientService catClientService;
    @GetMapping("/catClientShow")
    public String showAllCatClient(Model model){
        model.addAttribute("listeCatClient",catClientService.showAllCatClient());
        //pas obligé d'avoir le mm nom que le return
        return "admin/ListeCatClient";
    }
    @GetMapping("/catClientForm")
    public String showFormCatClient(){
        return "admin/FormCatClient";
    }
    @PostMapping("/catClient/save")
    public String saveCatClient(CatClient catClient){
        catClientService.saveCatClient(catClient);
        return "redirect:/catClientShow";
    }
}
