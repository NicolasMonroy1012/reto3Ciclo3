/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.G22.Reto3.web;

import java.util.List;
import java.util.Optional;

import com.usa.G22.Reto3.entities.Message;
import com.usa.G22.Reto3.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    
    @GetMapping("/all")
    public List<Message> getMessages(){
        return messageService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int messageId){
        return messageService.getMessage(messageId);
    }
    
    @PostMapping("/save")
    public Message save(@RequestBody Message message){
        return messageService.save(message);
    }
    @ResponseStatus(HttpStatus.CREATED)


    @PutMapping("/update")
    public Message update(@RequestBody Message message){
        return messageService.update(message);
    }
    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int carId){
        return messageService.deleteCategory(carId);
    }
}
