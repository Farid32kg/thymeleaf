package com.thymeleaf.thymeleaf;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Clients> getAll(){
        return clientRepository.findAll();
    }

    public Clients addClient(Clients clients){
        return clientRepository.save(clients);
    }

    public Clients updateClients (Long id, Clients details){
        Clients clients=clientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not found"));
        clients.setId(details.getId());
        clients.setName(details.getName());
        clients.setAge(details.getAge());
        return clientRepository.save(clients);
    }

    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }


}
