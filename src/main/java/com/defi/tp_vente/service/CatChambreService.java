package com.defi.tp_vente.service;

import com.defi.tp_vente.modele.CatChambre;
import com.defi.tp_vente.modele.Categorie;
import com.defi.tp_vente.modele.Chambre;
import com.defi.tp_vente.repository.CatChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatChambreService {
    @Autowired
    private CatChambreRepository catChambreRepository;


    public List<CatChambre> showAllCatCham(){
        return catChambreRepository.findAll();
    }

    public void saveCatCham(CatChambre catChambre) {catChambreRepository.save(catChambre);
    }
    public List<CatChambre> showAllPrix() {return catChambreRepository.findAll();
    }
}
