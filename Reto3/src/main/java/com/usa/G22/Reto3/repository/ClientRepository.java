/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.G22.Reto3.repository;


import java.util.List;
import java.util.Optional;

import com.usa.G22.Reto3.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cktv
 */
@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    //Get ALl
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <Client> getMessage(int id){
        return clientCrudRepository.findById(id);
    }
    
    //SAVE
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
    
    //DELETE
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
    
}
