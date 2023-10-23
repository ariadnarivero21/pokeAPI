package com.bewise.pasantia.pokeapi.controller;

import com.bewise.pasantia.pokeapi.app.ItemService;
import com.bewise.pasantia.pokeapi.dto.ItemRequestDto;
import com.bewise.pasantia.pokeapi.model.Item;
import com.bewise.pasantia.pokeapi.repository.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {
    private ItemService itemService;
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Item crearNuevoItem(@RequestBody ItemRequestDto itemRequestDto){
        return itemService.crearNuevoItem(itemRequestDto);
    }
    @GetMapping
    public List<Item> obtenerLosItem(){
        return itemService.obtenerTodosLosItem();
    }

    @PutMapping("/{id}")
    public Item actualizar(@PathVariable int id, ItemRequestDto itemRequestDto){
        Optional<Item> item = itemService.buscarPorId(id);
        if(item.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el item");
        }
        Item itemNuevo = itemRequestDto.convert();
        return itemService.actualizar(itemNuevo);
    }

    @PatchMapping("/{id}")
    public Item actualizarParcialmente(@PathVariable int id, ItemRequestDto itemRequestDto){
        Optional<Item> item = itemService.buscarPorId(id);
        if(item.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el item");
        }
        Item itemNuevo = itemRequestDto.partialConvert(item.get());
        return itemService.actualizar(itemNuevo);
    }

    @DeleteMapping("/{id}")
    public void borrarPorId(@PathVariable int id){
        Optional<Item> item = itemService.buscarPorId(id);
        if(item.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el item");
        }
        itemService.borrarItem(item.get());
    }

}
