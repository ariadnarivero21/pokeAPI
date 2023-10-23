package com.bewise.pasantia.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre")
    private String nombre;
    @Column(name="pp")
    private int pp;
    @Column(name="fuerza")
    private float fuerza;
    @Column(name="tipo_elemental")
    private String tipoElemental;

    @ManyToMany(mappedBy = "movimientos")
    @JsonBackReference
    private List<Pokemon> pokemon;

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public float getFuerza() {
        return fuerza;
    }

    public void setFuerza(float fuerza) {
        this.fuerza = fuerza;
    }

    public String getTipoElemental() {
        return tipoElemental;
    }

    public void setTipoElemental(String tipoElemental) {
        this.tipoElemental = tipoElemental;
    }
}
