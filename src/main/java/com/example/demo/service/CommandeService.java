package com.example.demo.service;

import com.example.demo.dtos.CommandeDto;
import com.example.demo.entities.Client;
import com.example.demo.entities.Commande;

import java.time.LocalDate;
import java.util.List;

public interface CommandeService {
    CommandeDto saveCommande(CommandeDto commande);

    CommandeDto updateCommande(CommandeDto commande);

    void deleteCommande(Commande commande);

    void deleteCommandeById(Long id);

    CommandeDto getCommande(Long id);

    List<CommandeDto> getAllCommandes();

    List<Commande> findByTotal(Double total);

    List<Commande> findCommandeByClient_NomClient(String nomClient);

    List<Commande> findByClientIdClient(Long id);

    List<Commande> findByOrderByTotalAsc();

    List<Commande> trierCommandesTotalDateCreation();

    List<Commande> findByTotalAndDateCreation(Double total, LocalDate dateCreation);

    List<Commande> findByClient(Client client);

    CommandeDto convertEntityToDto (Commande commande);

    Commande convertDtoToEntity(CommandeDto commandeDto);
}
