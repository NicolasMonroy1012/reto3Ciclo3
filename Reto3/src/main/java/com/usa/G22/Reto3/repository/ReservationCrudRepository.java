/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.G22.Reto3.repository;



import com.usa.G22.Reto3.entities.Reservation;
import com.usa.G22.Reto3.entities.Skate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    @Query("select c.client ,count (c.client)from Reservation as c group by c.client order by count (c.status) desc")
    public List<Object[]> countTotalReservationByClient();
    public List<Reservation> findAllByStartDateAfterAndStartDateAfter(Date dateOne,Date dateTwo);
    public List<Reservation>findAllByStatus(String status);
}
