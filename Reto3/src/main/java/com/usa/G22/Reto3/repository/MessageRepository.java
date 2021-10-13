/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.G22.Reto3.repository;


import java.util.List;
import java.util.Optional;

import com.usa.G22.Reto3.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cktv
 */
@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    //Get ALl
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    
    //SAVE
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    
    //DELETE
    public void delete(Message message){
        messageCrudRepository.delete(message);
    }
    
}
