package com.defi.tp_vente.service;

import com.defi.tp_vente.modele.Facturation;
import com.defi.tp_vente.modele.Reservation;
import com.defi.tp_vente.repository.FacturationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturationService {
    @Autowired
    private FacturationRepository facturationRepository;

    public List<Facturation> showAllFact() {return facturationRepository.findAll();
    }

    public void saveFact(Facturation facturation) {facturationRepository.save(facturation);
    }

    public Facturation showOneFact(int id) {return facturationRepository.findById(id).get();
    }

    public void deleteFact(int id) {facturationRepository.deleteById(id);}
}
