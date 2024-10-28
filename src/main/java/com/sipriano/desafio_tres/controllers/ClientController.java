package com.sipriano.desafio_tres.controllers;

import com.sipriano.desafio_tres.entities.Client;
import com.sipriano.desafio_tres.entities.ClientDTO;
import com.sipriano.desafio_tres.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public Page<ClientDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ClientDTO insert(@RequestBody ClientDTO clientDTO) {
        return service.insert(clientDTO);
    }

    @PutMapping(value = "/{id}")
    public ClientDTO update(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        return service.update(id, clientDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
