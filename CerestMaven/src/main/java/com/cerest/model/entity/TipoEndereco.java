/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cerest.model.entity;

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
@Table(name="TipoEndereco")
public class TipoEndereco {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue
    @Column(name="TipoEndereco",nullable = false)
    private Integer idTipoEndereco;
    
    @Column(name="Descricao",nullable = false,length = 80)
    private String descricao;

    public TipoEndereco() {
    }
    
    @OneToMany(mappedBy = "TipoEndereco",fetch = FetchType.LAZY)
    @ForeignKey(name="TipoEnderecoEndereco")
    private List<Endereco> enderecos;

    public Integer getIdTipoEndereco() {
        return idTipoEndereco;
    }

    public void setIdTipoEndereco(Integer idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idTipoEndereco);
        return hash;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoEndereco other = (TipoEndereco) obj;
        if (!Objects.equals(this.idTipoEndereco, other.idTipoEndereco)) {
            return false;
        }
        return true;
    }
    
}
