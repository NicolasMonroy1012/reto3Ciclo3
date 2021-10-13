/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.G22.Reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    private String messageText;
    private Integer stars;

    @OneToOne
    @JsonIgnoreProperties({"score"})
    private Reservation reservation;

    public Score() {
    }

    public Score(Integer idScore, String messageText, Integer stars, Reservation reservation) {
        this.idScore = idScore;
        this.messageText = messageText;
        this.stars = stars;
        this.reservation = reservation;
    }

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
