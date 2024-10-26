package com.sipriano.desafio_tres.services;

import com.sipriano.desafio_tres.entities.Client;
import com.sipriano.desafio_tres.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    public Client findById(Long id) {
        Optional<Client> clientOptional = repository.findById(id);
        Client client = clientOptional.orElseThrow(() -> new NoSuchElementException("Elemento não encontrado!"));
        return client;
    }

}
