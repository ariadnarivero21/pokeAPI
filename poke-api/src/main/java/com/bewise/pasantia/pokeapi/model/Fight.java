package com.bewise.pasantia.pokeapi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Fight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Date fechaHora;
    @Column
    private String lugar;
    @Column
    private BigDecimal plataEnJuego;

    @ManyToOne
    @JoinColumn(name = "id_pokemon_ganador")
    private Pokemon pokemonGanador;

    @ManyToOne
    @JoinColumn(name = "id_pokemon_perdedor")
    private Pokemon pokemonPerdedor;
}
