package com.sipriano.desafio_tres.services;

import com.sipriano.desafio_tres.entities.Client;
import com.sipriano.desafio_tres.entities.ClientDTO;
import com.sipriano.desafio_tres.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ClientDTO findById(Long id) {
        Optional<Client> clientOptional = repository.findById(id);
        Client client = clientOptional.orElseThrow(() -> new NoSuchElementException("Elemento não encontrado!"));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
         return repository.findAll(pageable).map(ClientDTO::new);
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = new Client();
        copyDTOToClient(clientDTO, client);
        return new ClientDTO(repository.save(client));
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        Client client = repository.getReferenceById(id);
        copyDTOToClient(clientDTO, client);
        return new ClientDTO(repository.save(client));
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void copyDTOToClient(ClientDTO clientDTO, Client client) {
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setChildren(clientDTO.getChildren());
    }

}
