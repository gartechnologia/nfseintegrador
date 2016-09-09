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
@Table(name = "matriculas")
public class Matricula implements Serializable {
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
    private int id; 
    
    @ManyToOne
    @JoinColumn(name = "turmas", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_turmas"))
    private Turma turma;
     
    @ManyToOne
    @JoinColumn(name = "alunos", referencedColumnName = "alunoID", nullable = false, foreignKey = @ForeignKey(name = "fk_alunos"))
    private Aluno aluno;
    
    @Column(name = "data_inicio")
    private Date data_matricula;    

    
}
