/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cerest.model.entity;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author moraes
 */
@Entity
@Table(name="Estado")
public class Estado {
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue
    @Column(name="Estado",nullable = false)
    private Integer idEstado;
    
    @Column(name="Descricao",nullable = false,length =80)
    private String Descricao;
    
    @Column(name="Sigla",nullable = false,length = 2)
    private String sigla;

    @OneToMany
    @ForeignKey(name="EstadoEndereco")
    private List<Endereco> enderecos;
    
    public Estado() {
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idEstado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.idEstado, other.idEstado)) {
            return false;
        }
        return true;
    }
    
    
    
}
