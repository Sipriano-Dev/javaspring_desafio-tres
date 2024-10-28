package com.sipriano.desafio_tres.controllers;

import com.sipriano.desafio_tres.entities.Client;
import com.sipriano.desafio_tres.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping(value = "/{id}")
    public Client findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Client> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Client insert(@RequestBody Client client) {
        return service.insert(client);
    }

    @PutMapping(value = "/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client) {
        return service.update(id, client);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
