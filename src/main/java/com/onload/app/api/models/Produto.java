/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.onload.app.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author alan
 */
@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "a data é obrigatório")
    private String data;
    private String foto;   
    @NotBlank(message = "o nome é obrigatório")    
    private String nome;    
    @NotBlank(message = "a descrição é obrigatória")
    private String descricao;
    private float preco_unitario;
    private float preco_venda;    

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the preco_unitario
     */
    public float getPreco_unitario() {
        return preco_unitario;
    }

    /**
     * @param preco_unitario the preco_unitario to set
     */
    public void setPreco_unitario(float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    /**
     * @return the preco_venda
     */
    public float getPreco_venda() {
        return preco_venda;
    }

    /**
     * @param preco_venda the preco_venda to set
     */
    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

 
}
