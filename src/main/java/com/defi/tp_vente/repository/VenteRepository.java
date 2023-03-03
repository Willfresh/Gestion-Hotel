package com.defi.tp_vente.repository;
import com.defi.tp_vente.modele.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Integer> {
   /* @Modifying
    @Transactional
    @Query("Update Article v set v.qteStock=v.qteStock -:qte_art where v.id=:id_Art")
    void degradeStockArticle(@Param("qte_art") int qte_art, @Param("id_Art") int id_Art);
*/
   @Query("select v from Vente v where v.qteVente like %?1%")
   List<Vente> findByQuant(int qte);
}
