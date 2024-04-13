package com.defi.tp_vente.repository;

import com.defi.tp_vente.modele.CatChambre;
import com.defi.tp_vente.modele.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface CatChambreRepository extends JpaRepository<CatChambre,Integer> {
}
