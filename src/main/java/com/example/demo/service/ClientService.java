package com.example.demo.service;

import java.util.List;

import com.example.demo.dtos.ClientDto;
import com.example.demo.entities.Client;

public interface ClientService {
	List<ClientDto> getAllClients();

    ClientDto convertEntityToDto (Client client);

    Client convertDtoToEntity(ClientDto clientDto);
}
