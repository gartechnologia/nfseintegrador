/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gartech.nfse.integrador.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Gilson
 */
@Entity
@Table(name = "unidade_educacional")
public class UnidadeEducacional implements Serializable {
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "seq_unidade_educacional", sequenceName = "seq_unidade_educacional_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_unidade_educacional", strategy = GenerationType.SEQUENCE)
    private int unidade_educacionalID;         
    
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;    
    
    @Column(name = "numerodocumento", length = 14, nullable = false)
    private String numeroDocumento;
    
    @Column(name = "inscricaomunicipal", length = 14, nullable = false)
    private String inscricaoMunicipal;    
}
