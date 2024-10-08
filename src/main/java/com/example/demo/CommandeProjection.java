package com.example.demo;

import com.example.demo.entities.Client;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomClient", types = {Client.class})
public interface CommandeProjection {
    public String getNomClient();
}
