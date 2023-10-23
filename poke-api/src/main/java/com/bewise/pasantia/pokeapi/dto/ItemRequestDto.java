package com.bewise.pasantia.pokeapi.dto;

import com.bewise.pasantia.pokeapi.model.Item;
import jakarta.persistence.Column;

import java.math.BigDecimal;

public class ItemRequestDto {
    private String nombre;
    private String tipo;
    private Integer cantidad;
    private BigDecimal precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Item convert(Item item){
        item.setNombre(this.getNombre());
        item.setCantidad(this.getCantidad());
        item.setTipo(this.getTipo());
        item.setPrecio(this.getPrecio());

        return item;
    }

    public Item convert(){
        return convert(new Item());
    }

    public Item partialConvert(Item item){
        if(this.getNombre() != null){
            item.setNombre(this.getNombre());
        }
        if(this.getTipo() != null){
            item.setTipo(this.getTipo());
        }
        if(this.getCantidad() != null){

        }
        if(this.getPrecio() != null) {
            item.setPrecio(this.getPrecio());
        }
        return item;
    }

}
