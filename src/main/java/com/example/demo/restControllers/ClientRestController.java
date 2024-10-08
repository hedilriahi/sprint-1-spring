package com.example.demo.restControllers;

import com.example.demo.dtos.ClientDto;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clients")
@CrossOrigin
public class ClientRestController {
    @Autowired
    ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }
}
