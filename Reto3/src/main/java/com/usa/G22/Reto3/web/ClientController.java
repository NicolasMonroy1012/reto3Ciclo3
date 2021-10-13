/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.G22.Reto3.web;


import java.util.List;
import java.util.Optional;

import com.usa.G22.Reto3.entities.Client;
import com.usa.G22.Reto3.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    
    @GetMapping("/all")
    public List<Client> getClients(){
        return clientService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int clientId){
        return clientService.getClient(clientId);
    }
    
    @PostMapping("/save")
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }
    @ResponseStatus(HttpStatus.CREATED)


    @PutMapping("/update")
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }
    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int carId){
        return clientService.deleteClient(carId);
    }
}
