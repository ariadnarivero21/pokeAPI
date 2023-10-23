package com.bewise.pasantia.pokeapi.dto;

import com.bewise.pasantia.pokeapi.model.Move;
import jakarta.persistence.Column;

public class MoveRequestDto {

    private String nombre;
    private Integer pp;
    private Integer fuerza;
    private String tipoElemental;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getPp() {
        return pp;
    }
    public void setPp(Integer pp) {
        this.pp = pp;
    }
    public Integer getFuerza() {
        return fuerza;
    }
    public void setFuerza(Integer fuerza) {
        this.fuerza = fuerza;
    }
    public String getTipoElemental() {
        return tipoElemental;
    }
    public void setTipoElemental(String tipoElemental) {
        this.tipoElemental = tipoElemental;
    }

    public Move convert(Move move){
        move.setNombre(this.getNombre());
        move.setFuerza(this.getFuerza());
        move.setTipoElemental(this.getTipoElemental());
        move.setPp(this.getPp());

        return move;
    }

    public Move convert(){
        return convert(new Move());
    }
    public Move partialConvert(Move move){
        if(this.getNombre() != null){
            move.setNombre(this.getNombre());
        }
        if(this.getPp() != null){
            move.setPp(this.getPp());
        }
        if(this.getFuerza() != null){
            move.setFuerza(this.getFuerza());
        }
        if(this.getTipoElemental() != null){
            move.setTipoElemental(this.getTipoElemental());
        }

        return move;
    }
}
