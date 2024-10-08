package com.example.demo.service;

import com.example.demo.dtos.CommandeDto;
import com.example.demo.entities.Client;
import com.example.demo.entities.Commande;
import com.example.demo.repos.CommandeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public CommandeDto saveCommande(CommandeDto commande) {
        return convertEntityToDto( commandeRepository.save(convertDtoToEntity(commande)));
    }

    @Override
    public CommandeDto updateCommande(CommandeDto commande) {
        return convertEntityToDto( commandeRepository.save(convertDtoToEntity(commande)));
    }

    @Override
    public void deleteCommande(Commande commande) {
        commandeRepository.delete(commande);
    }

    @Override
    public void deleteCommandeById(Long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public CommandeDto getCommande(Long id) {
        return convertEntityToDto(commandeRepository.findById(id).get());
    }

    @Override
    public List<CommandeDto> getAllCommandes() {
        return commandeRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Commande> findByTotal(Double total) {
        return commandeRepository.findCommandeByTotal(total);
    }

    @Override
    public List<Commande> findCommandeByClient_NomClient(String nomClient) {
        return commandeRepository.findCommandeByClient_NomClient(nomClient);
    }

    @Override
    public List<Commande> findByClientIdClient(Long id) {
        return commandeRepository.findByClientIdClient(id);
    }

    @Override
    public List<Commande> findByOrderByTotalAsc() {
        return commandeRepository.findByOrderByTotalAsc();
    }

    @Override
    public List<Commande> trierCommandesTotalDateCreation() {
        return commandeRepository.trierCommandesTotalDateCreation();
    }

    @Override
    public List<Commande> findByTotalAndDateCreation(Double total, LocalDate dateCreation) {
        return commandeRepository.findByTotalAndDateCreation(total, dateCreation);
    }

    @Override
    public List<Commande> findByClient(Client client) {
        return commandeRepository.findByClient(client);
    }

    @Override
    public CommandeDto convertEntityToDto(Commande commande) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(commande, CommandeDto.class);
    }

    @Override
    public Commande convertDtoToEntity(CommandeDto commandeDto){
        return modelMapper.map(commandeDto, Commande.class);
    }

}
