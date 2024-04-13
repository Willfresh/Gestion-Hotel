package com.defi.tp_vente.service;

import com.defi.tp_vente.modele.CatClient;
import com.defi.tp_vente.repository.CatClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatClientService {
    @Autowired
    private CatClientRepository catClientRepository;

    public List<CatClient> showAllCatClient(){
        return catClientRepository.findAll();
    }

    public void saveCatClient(CatClient catClient) {catClientRepository.save(catClient);
    }
}
