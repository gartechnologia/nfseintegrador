/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gartech.nfse.integrador.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Gilson
 */
@Entity(name = "Paises")
public class Pais implements Serializable {
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paisID; 
    
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;
    
    @Column(name = "iso", nullable = true, length = 20)
    private String iso;

    public Pais() {
    }

    /**
     * @return the paisID
     */
    public int getPaisID() {
        return paisID;
    }

    /**
     * @param paisID the paisID to set
     */
    public void setPaisID(int paisID) {
        this.paisID = paisID;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the iso
     */
    public String getIso() {
        return iso;
    }

    /**
     * @param iso the iso to set
     */
    public void setIso(String iso) {
        this.iso = iso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.paisID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        if (this.paisID != other.paisID) {
            return false;
        }
        return true;
    }

    
    
}
