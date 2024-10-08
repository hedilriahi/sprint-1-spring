package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	private String nomClient;
	private String prenomClient;
	private String adresseClient;

	@OneToMany(mappedBy = "client")
	@JsonIgnore
	private List<Commande> commandes;

	public Client(String name, String lastname, String address) {
		this.nomClient = name;
		this.prenomClient = lastname;
		this.adresseClient = address;
	}
}
