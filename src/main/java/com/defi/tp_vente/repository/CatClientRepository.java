package com.defi.tp_vente.repository;

import com.defi.tp_vente.modele.CatClient;
import com.defi.tp_vente.modele.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CatClientRepository extends JpaRepository<CatClient,Integer> {
}
