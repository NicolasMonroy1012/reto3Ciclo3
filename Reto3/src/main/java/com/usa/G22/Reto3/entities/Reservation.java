/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.G22.Reto3.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "reservation")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Reservation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar startDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar devolutionDate;
    private String status="created";
    
    @ManyToOne
    @JoinColumn(name = "skateId")
    @JsonIgnoreProperties({"reservations"})
    private Skate skate;
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    
    @OneToOne
    @JsonIgnoreProperties("reservation")
    private Score score;

    public Reservation() {
    }

    public Reservation(Integer idReservation, Calendar startDate, Calendar devolutionDate, String status, Skate skate, Client client, Score score) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.skate = skate;
        this.client = client;
        this.score = score;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Calendar devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Skate getSkate() {
        return skate;
    }

    public void setSkate(Skate skate) {
        this.skate = skate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
