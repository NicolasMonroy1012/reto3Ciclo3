/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.G22.Reto3.repository;


import java.util.List;
import java.util.Optional;

import com.usa.G22.Reto3.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    //Get ALl
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    //SAVE
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    
    //DELETE
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
    
}
