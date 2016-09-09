/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gartech.nfse.integrador.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Gilson
 */
@Entity
@Table(name = "turmas")
public class Turma implements Serializable{
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "seq_turma", sequenceName = "seq_turma_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_turma", strategy = GenerationType.SEQUENCE)
    private int id; 
    
    @ManyToOne
    @JoinColumn(name = "instrutores", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_instrutor"))
    private Instrutor instrutor;

    @ManyToOne
    @JoinColumn(name = "cursos", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_curso"))
    private Curso curso;
    
    @Column(name = "data_inicio")
    private Date data_inicio;    

    @Column(name = "data_final")
    private Date data_final;        

    public Turma() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the instrutor
     */
    public Instrutor getInstrutor() {
        return instrutor;
    }

    /**
     * @param instrutor the instrutor to set
     */
    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * @return the data_inicio
     */
    public Date getData_inicio() {
        return data_inicio;
    }

    /**
     * @param data_inicio the data_inicio to set
     */
    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    /**
     * @return the data_final
     */
    public Date getData_final() {
        return data_final;
    }

    /**
     * @param data_final the data_final to set
     */
    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
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
        final Turma other = (Turma) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
}
