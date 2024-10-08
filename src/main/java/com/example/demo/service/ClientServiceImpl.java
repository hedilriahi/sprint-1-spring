package com.example.demo.service;
import java.util.List;

import com.example.demo.dtos.ClientDto;
import com.example.demo.dtos.CommandeDto;
import com.example.demo.entities.Commande;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Client;
import com.example.demo.repos.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
    ClientRepository   clientRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream().map(this::convertEntityToDto).toList();
    }

    @Override
    public ClientDto convertEntityToDto(Client client) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(client, ClientDto.class);
    }

    @Override
    public Client convertDtoToEntity(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }


}