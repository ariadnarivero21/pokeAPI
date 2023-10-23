package com.bewise.pasantia.pokeapi.dto;

import com.bewise.pasantia.pokeapi.model.Move;
import com.bewise.pasantia.pokeapi.model.Pokemon;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PokemonRequestDto {

    private String nombre;

    private Integer numPokedex;

    private BigDecimal plata;

    private String tipoElemental;

    private Integer puntosDeVida;

    private Integer puntosDeAtaque;

    private Integer nivel;

    private List<Integer> movesId;

    public List<Integer> getMovesId() {
        return movesId;
    }

    public void setMovesId(List<Integer> movesId) {
        this.movesId = movesId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumPokedex() {
        return numPokedex;
    }

    public void setNumPokedex(Integer numPokedex) {
        this.numPokedex = numPokedex;
    }

    public BigDecimal getPlata() {
        return plata;
    }

    public void setPlata(BigDecimal plata) {
        this.plata = plata;
    }

    public String getTipoElemental() {
        return tipoElemental;
    }

    public void setTipoElemental(String tipoElemental) {
        this.tipoElemental = tipoElemental;
    }

    public Integer getPuntosDeVida() {
        return puntosDeVida;
    }

    public void setPuntosDeVida(Integer puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }

    public Integer getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public void setPuntosDeAtaque(Integer puntosDeAtaque) {
        this.puntosDeAtaque = puntosDeAtaque;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Pokemon convert(Pokemon pokemon){
        pokemon.setNombre(this.getNombre());
        pokemon.setNumPokedex(this.getNumPokedex());
        pokemon.setPlata(this.getPlata());
        pokemon.setTipoElemental(this.getTipoElemental());
        pokemon.setPuntosDeVida(this.getPuntosDeVida());
        pokemon.setPuntosDeAtaque(this.getPuntosDeAtaque());
        pokemon.setNivel(this.getNivel());

        return pokemon;
    }

    public Pokemon convert(){
        return convert(new Pokemon());
    }

    public Pokemon partialConvert(Pokemon pokemon){
        if(this.getNombre() != null) {
            pokemon.setNombre(this.getNombre());
        }
        if(this.getPlata() != null){
            pokemon.setPlata(this.getPlata());
        }
        if(this.getNumPokedex() != null){
            pokemon.setNumPokedex(this.getNumPokedex());
        }
        if(this.getTipoElemental() != null){
            pokemon.setTipoElemental(this.getTipoElemental());
        }
        if(this.getPuntosDeVida() != null){
            pokemon.setPuntosDeVida(this.getPuntosDeVida());
        }
        if(this.getPuntosDeAtaque() != null) {
            pokemon.setPuntosDeAtaque(this.getPuntosDeAtaque());
        }
        if(this.getNivel() != null){
            pokemon.setNivel(this.getNivel());
        }

        return pokemon;
    }
}