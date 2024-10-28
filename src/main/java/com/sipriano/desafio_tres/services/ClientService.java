package com.sipriano.desafio_tres.services;

import com.sipriano.desafio_tres.entities.Client;
import com.sipriano.desafio_tres.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    @Transactional(readOnly = true)
    public Client findById(Long id) {
        Optional<Client> clientOptional = repository.findById(id);
        Client client = clientOptional.orElseThrow(() -> new NoSuchElementException("Elemento não encontrado!"));
        return client;
    }

    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Client insert(Client client) {
        return repository.save(client);
    }

    @Transactional
    public Client update(Long id, Client client) {
        Client actualClient = repository.getReferenceById(id);
        actualClient.setName(client.getName());
        actualClient.setCpf(client.getCpf());
        actualClient.setIncome(client.getIncome());
        actualClient.setBirthDate(client.getBirthDate());
        actualClient.setChildren(client.getChildren());
        return repository.save(actualClient);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
