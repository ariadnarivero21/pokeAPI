package com.bewise.pasantia.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.Remove;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(
            name ="pokemon_has_move",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "move_id"))
    private List<Move> movimientos;

    @Column
    private String nombre;
    @Column
    private int numPokedex;
    @Column
    private BigDecimal plata;
    @Column(name="tipo_elemental")
    private String tipoElemental;
    @Column
    private int puntosDeVida;
    @Column
    private int puntosDeAtaque;
    @Column
    private int nivel;


    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<Move> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Move> movimientos) {
        this.movimientos = movimientos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPokedex() {
        return numPokedex;
    }

    public void setNumPokedex(int numPokedex) {
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
    public int getPuntosDeVida() {
        return puntosDeVida;
    }
    public void setPuntosDeVida(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }
    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }
    public void setPuntosDeAtaque(int puntosDeAtaque) {
        this.puntosDeAtaque = puntosDeAtaque;
    }


}
