package com.defi.tp_vente.service;

import com.defi.tp_vente.modele.Chambre;
import com.defi.tp_vente.modele.Client;
import com.defi.tp_vente.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public void saveClient(Client client){
        clientRepository.save(client);
    }

    public List<Client> showAllClient(){
        return clientRepository.findAll();
    }

    public List<Client> showAllNom() {return clientRepository.findAll();
    }

    public Client showOneClient(int id) {return clientRepository.findById(id).get();}

    public void deleteClient(int id) {clientRepository.deleteById(id);
    }

    public List<Client> getAllClients() {return clientRepository.findAll();
    }
}
