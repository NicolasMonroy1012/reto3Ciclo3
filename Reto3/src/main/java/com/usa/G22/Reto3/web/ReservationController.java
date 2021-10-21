/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.G22.Reto3.web;


import java.util.List;
import java.util.Optional;

import com.usa.G22.Reto3.entities.Reservation;
import com.usa.G22.Reto3.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")

    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }
    
    @GetMapping("/{id}")

    public Optional<Reservation> getReservation(@PathVariable("idReservation") int Id){
        return reservationService.getReservation(Id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id){
        return reservationService.deleteReservation(Id);
    }
}
