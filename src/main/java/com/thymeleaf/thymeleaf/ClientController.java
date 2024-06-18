package com.thymeleaf.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("all-rest")
    public List<Clients> all(){
        return clientService.getAll();
    }

    @PostMapping("add")
    public Clients addClients(@RequestBody Clients clients){
        return clientService.addClient(clients);
    }

    @PutMapping("{id}")
    public ResponseEntity<Clients> editClient(@PathVariable Long id, @RequestBody Clients clients ){
        return ResponseEntity.ok(clientService.updateClients(id,clients));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();

    }


}
