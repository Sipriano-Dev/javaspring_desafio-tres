package com.sipriano.desafio_tres.controllers;

import com.sipriano.desafio_tres.entities.Client;
import com.sipriano.desafio_tres.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping(value = "/{id}")
    public Client findById(@PathVariable Long id) {
        return service.findById(id);
    }


}
