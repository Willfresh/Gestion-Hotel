package com.defi.tp_vente.repository;

import com.defi.tp_vente.modele.Categorie;
import com.defi.tp_vente.modele.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
}
