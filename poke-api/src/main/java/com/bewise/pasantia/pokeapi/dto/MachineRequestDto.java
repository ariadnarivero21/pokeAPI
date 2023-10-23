package com.bewise.pasantia.pokeapi.dto;

import com.bewise.pasantia.pokeapi.model.Item;
import com.bewise.pasantia.pokeapi.model.Machine;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MachineRequestDto {

    private String tipo;
    private String nombre;
    private Item item;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Machine convert(Machine machine){
        machine.setNombre(this.getNombre());
        machine.setTipo(this.getTipo());
        machine.setItem(this.item);

        return machine;
    }

    public Machine convert(){
        return convert(new Machine());
    }

    public Machine partialConvert(Machine machine){
        if(this.getNombre() != null){
            machine.setNombre(this.getNombre());
        }
        if(this.getTipo() != null){
            machine.setTipo(this.getTipo());
        }
        if(this.getItem() != null){
            machine.setItem(this.getItem());
        }
            return machine;
    }
}
