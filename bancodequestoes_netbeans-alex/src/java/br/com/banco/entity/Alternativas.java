/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.banco.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kellen
 */
@Entity
@Table(name = "alternativas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alternativas.findAll", query = "SELECT a FROM Alternativas a")
    , @NamedQuery(name = "Alternativas.findById", query = "SELECT a FROM Alternativas a WHERE a.id = :id")
    , @NamedQuery(name = "Alternativas.findByAlternativa", query = "SELECT a FROM Alternativas a WHERE a.alternativa = :alternativa")
    , @NamedQuery(name = "Alternativas.findByCorreta", query = "SELECT a FROM Alternativas a WHERE a.correta = :correta")})
public class Alternativas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2048)
    @Column(name = "alternativa")
    private String alternativa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correta")
    private short correta;
    @JoinColumn(name = "questao", referencedColumnName = "id")
    @ManyToOne
    private Questao questao;

    public Alternativas() {
    }

    public Alternativas(Integer id) {
        this.id = id;
    }

    public Alternativas(Integer id, String alternativa, short correta) {
        this.id = id;
        this.alternativa = alternativa;
        this.correta = correta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }

    public short getCorreta() {
        return correta;
    }

    public void setCorreta(short correta) {
        this.correta = correta;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alternativas)) {
            return false;
        }
        Alternativas other = (Alternativas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.banco.entity.Alternativas[ id=" + id + " ]";
    }
    
}
