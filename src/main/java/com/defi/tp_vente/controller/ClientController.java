package com.defi.tp_vente.controller;

import com.defi.tp_vente.modele.Client;
import com.defi.tp_vente.service.CatClientService;
import com.defi.tp_vente.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class ClientController {

    @Autowired
    private CatClientService catClientService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/clientShow")
    public String showAllClient(Model model){
        model.addAttribute("listeClient",clientService.showAllClient());
        //pas obligé d'avoir le mm nom que le return
        return "admin/ListeClient";
    }

    @GetMapping("/clientForm")
    public String ShowFormClient(Model model){
        model.addAttribute("listeCatClient",catClientService.showAllCatClient());
        return "admin/FormClient";
    }
    @PostMapping("/client/save")
    public String saveClient(Client client){
        clientService.saveClient(client);
        return "redirect:/clientShow";
    }
    /*@GetMapping("/clients/ids")
    public List<Integer> getClientIds() {
        List<Client> clients = clientService.getAllClients();
        return clients.stream().map(Client::getId).collect(Collectors.toList());
    }
    @GetMapping("/clients/count")
    public int getClientCount() {
        List<Integer> clientIds = getClientIds();
        return clientIds.size();
    }*/
    @GetMapping("/clientEdit{id}")
    public String clientEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("Un_client",clientService.showOneClient(id));
        model.addAttribute("listeCatClient",catClientService.showAllCatClient());
        return "admin/clientEdit";
    }
    @PostMapping("client/update")
    public  String updateClient(@ModelAttribute("client") Client client){
        clientService.saveClient(client);
        return "redirect:/clientShow";

    }
    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable("id") int id){
        clientService.deleteClient(id);
        return "redirect:/clientShow";
    }



}
