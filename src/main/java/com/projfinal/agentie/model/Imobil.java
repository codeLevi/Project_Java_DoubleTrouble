package com.projfinal.agentie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imobil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String adresa;
    private String agent;
    @Column(name = "nr_camere")
    private int nrCamere;
    private int suprafata;
    private String tipul;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public int getNrCamere() {
        return nrCamere;
    }

    public void setNrCamere(int nrCamere) {
        this.nrCamere = nrCamere;
    }

    public int getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(int suprafata) {
        this.suprafata = suprafata;
    }

    public String getTipul() {
        return tipul;
    }

    public void setTipul(String tipul) {
        this.tipul = tipul;
    }
}
