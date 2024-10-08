package com.example.demo.repos;

import com.example.demo.entities.Client;
import com.example.demo.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource(path = "rest")
public interface CommandeRepository extends JpaRepository<Commande, Long> {

    List<Commande> findCommandeByTotal(Double total);

    List<Commande> findCommandeByClient_NomClient(String nomClient);

    List<Commande> findByClientIdClient(Long id);

    List<Commande> findByOrderByTotalAsc();

    @Query("select c from Commande c order by c.total ASC, c.dateCreation DESC")
    List<Commande> trierCommandesTotalDateCreation();


    @Query("select c from Commande c where c.total = :total and c.dateCreation = :dateCreation")
    List<Commande> findByTotalAndDateCreation(@Param("total") Double total, @Param("dateCreation") LocalDate dateCreation);

    @Query("select c from Commande c where c.client = ?1")
    List<Commande> findByClient (Client client);
}
