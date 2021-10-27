package com.usa.G22.Reto3.entities.custom;

import com.usa.G22.Reto3.entities.Client;

public class clientCount {
    private Long total;
    private Client client;

    public clientCount() {
    }

    public clientCount(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
