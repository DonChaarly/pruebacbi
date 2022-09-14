
package com.prueba.demo.models.entitys;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Roles implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoles;
    
    private String nombre;
    
    private Boolean diaSemana;
    
    private Boolean buscaOaxaca;
    
    private Boolean verPokemon;
    
    private Boolean solicitarPokemon;
    
    private Boolean editarPokemon;
    
    private Boolean eliminarPokemon;

    public Long getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(Long idRoles) {
        this.idRoles = idRoles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    public Boolean getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Boolean diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Boolean getBuscaOaxaca() {
        return buscaOaxaca;
    }

    public void setBuscaOaxaca(Boolean buscaOaxaca) {
        this.buscaOaxaca = buscaOaxaca;
    }

    public Boolean getVerPokemon() {
        return verPokemon;
    }

    public void setVerPokemon(Boolean verPokemon) {
        this.verPokemon = verPokemon;
    }

    public Boolean getSolicitarPokemon() {
        return solicitarPokemon;
    }

    public void setSolicitarPokemon(Boolean solicitarPokemon) {
        this.solicitarPokemon = solicitarPokemon;
    }

    public Boolean getEditarPokemon() {
        return editarPokemon;
    }

    public void setEditarPokemon(Boolean editarPokemon) {
        this.editarPokemon = editarPokemon;
    }

    public Boolean getEliminarPokemon() {
        return eliminarPokemon;
    }

    public void setEliminarPokemon(Boolean eliminarPokemon) {
        this.eliminarPokemon = eliminarPokemon;
    }
    
    
    
}
