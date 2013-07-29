/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cerest.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="TipoLogradouro")
public class TipoLogradouro implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue
    @Column(name="idTipoLogradouro",nullable = false)
    private Integer idTipoLogradouro;

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    @Column(name="Descricao",nullable = false,length = 80)
    private String descricao;
    
    @OneToMany(mappedBy = "TipoLogradouro", fetch = FetchType.LAZY)
    @ForeignKey(name="TipoLogradouroEndereco")
    private List<Endereco> enderecos;
    public TipoLogradouro() {
    }

    public Integer getIdTipoLogradouro() {
        return idTipoLogradouro;
    }

    public void setIdTipoLogradouro(Integer idTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idTipoLogradouro);
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
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (!Objects.equals(this.idTipoLogradouro, other.idTipoLogradouro)) {
            return false;
        }
        return true;
    }
    
    
}
