package com.example.demo.dtos;

import com.example.demo.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeDto {
    private Long idCommande;
    private Double total;
    private String dateCreation;
    private Client client;
    private String nomClient;

}
