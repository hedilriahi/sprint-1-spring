package com.example.demo.restControllers;

import com.example.demo.dtos.CommandeDto;
import com.example.demo.entities.Commande;
import com.example.demo.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commandes")
@CrossOrigin
public class CommandeRestController {
    @Autowired
    CommandeService commandeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CommandeDto> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public CommandeDto getCommandeById(@PathVariable("id") Long id) {
        return commandeService.getCommande(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public CommandeDto createCommande(@RequestBody CommandeDto commande) {
        return commandeService.saveCommande(commande);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public CommandeDto updateCommande(@RequestBody CommandeDto commande) {
        return commandeService.updateCommande(commande);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteCommande(@PathVariable("id") Long id)
    {
        commandeService.deleteCommandeById(id);
    }

    @RequestMapping(value="/client/{idClient}",method = RequestMethod.GET)
    public List<Commande> getClientIdClient(@PathVariable("idClient") Long idClient) {
        return commandeService.findByClientIdClient(idClient);
    }

}
