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
@Table(name = "faturamento")
public class Faturamento implements Serializable{
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "seq_faturamento", sequenceName = "seq_faturamento_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_faturamento", strategy = GenerationType.SEQUENCE)
    private int faturamentoID;     
    
    @ManyToOne
    @JoinColumn(name = "unidade_educacional", referencedColumnName = "unidade_educacionalID", nullable = false, foreignKey = @ForeignKey(name = "fk_unidade_educacional"))    
    private UnidadeEducacional unidadeEducacional;
    
    @Column(name = "tipo_fatura", nullable = false, length = 1)
    private String tipoFatura;
    
    @Column(name = "ano_competencia")
    private int anoCompetencia;
    
    @Column(name = "mes_competencia")
    private int mesCompetencia;

    @ManyToOne
    @JoinColumn(name = "alunos", referencedColumnName = "alunoID", nullable = false, foreignKey = @ForeignKey(name = "fk_alunos"))    
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "cursos", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_cursos"))        
    private Curso curso;
    
    private Double valor;

    public Faturamento() {
    }

    /**
     * @return the faturamentoID
     */
    public int getFaturamentoID() {
        return faturamentoID;
    }

    /**
     * @param faturamentoID the faturamentoID to set
     */
    public void setFaturamentoID(int faturamentoID) {
        this.faturamentoID = faturamentoID;
    }

    /**
     * @return the unidadeEducacional
     */
    public UnidadeEducacional getUnidadeEducacional() {
        return unidadeEducacional;
    }

    /**
     * @param unidadeEducacional the unidadeEducacional to set
     */
    public void setUnidadeEducacional(UnidadeEducacional unidadeEducacional) {
        this.unidadeEducacional = unidadeEducacional;
    }

    /**
     * @return the tipoFatura
     */
    public String getTipoFatura() {
        return tipoFatura;
    }

    /**
     * @param tipoFatura the tipoFatura to set
     */
    public void setTipoFatura(String tipoFatura) {
        this.tipoFatura = tipoFatura;
    }

    /**
     * @return the anoCompetencia
     */
    public int getAnoCompetencia() {
        return anoCompetencia;
    }

    /**
     * @param anoCompetencia the anoCompetencia to set
     */
    public void setAnoCompetencia(int anoCompetencia) {
        this.anoCompetencia = anoCompetencia;
    }

    /**
     * @return the mesCompetencia
     */
    public int getMesCompetencia() {
        return mesCompetencia;
    }

    /**
     * @param mesCompetencia the mesCompetencia to set
     */
    public void setMesCompetencia(int mesCompetencia) {
        this.mesCompetencia = mesCompetencia;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.faturamentoID;
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
        final Faturamento other = (Faturamento) obj;
        if (this.faturamentoID != other.faturamentoID) {
            return false;
        }
        return true;
    }
    
    
    
}
