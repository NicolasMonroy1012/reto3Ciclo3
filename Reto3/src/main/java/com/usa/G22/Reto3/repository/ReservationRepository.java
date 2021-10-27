/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.G22.Reto3.repository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.usa.G22.Reto3.entities.Client;
import com.usa.G22.Reto3.entities.Reservation;
import com.usa.G22.Reto3.entities.custom.clientCount;
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

    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    public List<Reservation> getReservationsByPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateAfter(dateOne,dateTwo);
    }
    public List<clientCount> getTopClients(){
        List<clientCount> res=new ArrayList<>();

        List<Object[]> report=reservationCrudRepository.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){

            res.add(new clientCount((Long)report.get(i)[1], (Client) report.get(i)[0]));
        }
        return res;
    }
}

