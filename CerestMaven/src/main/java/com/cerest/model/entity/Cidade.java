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
@Table
public class Cidade {
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdCidade",nullable = false)
    private Integer idcidade;
    @Column(name="Nome",length = 80,nullable = false)
    private String nome;

    @OneToMany
    @ForeignKey(name="CidadeEndereco")
    private List<Endereco> enderecos;
    public Cidade() {
    }

    public Integer getIdcidade() {
        return idcidade;
    }

    public void setIdcidade(Integer idcidade) {
        this.idcidade = idcidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idcidade);
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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.idcidade, other.idcidade)) {
            return false;
        }
        return true;
    }
    
    
    

}
