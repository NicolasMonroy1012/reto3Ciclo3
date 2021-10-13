/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.G22.Reto3.services;


import java.util.List;
import java.util.Optional;

import com.usa.G22.Reto3.entities.Client;
import com.usa.G22.Reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientRepository.getMessage(id);
    }
    
    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> e=clientRepository.getMessage(client.getIdClient());
            if(e.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
    
    public Client update(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> e=clientRepository.getMessage(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getIdClient()!=null){
                    e.get().setIdClient(client.getIdClient());
                }
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    e.get().setEmail(client.getEmail());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                if(client.getMessages()!=null){
                    e.get().setMessages(client.getMessages());
                }
                if(client.getReservations()!=null){
                    e.get().setReservations(client.getReservations());
                }
                clientRepository.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }
    }
    
    public boolean deleteClient(int id){
        
        Boolean aBoolean=getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
    
}
