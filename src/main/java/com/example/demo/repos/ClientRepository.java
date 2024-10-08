package com.example.demo.repos;

import java.util.List;

import com.example.demo.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Client;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
