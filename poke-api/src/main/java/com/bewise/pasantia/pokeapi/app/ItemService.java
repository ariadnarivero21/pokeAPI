package com.bewise.pasantia.pokeapi.app;

import com.bewise.pasantia.pokeapi.dto.ItemRequestDto;
import com.bewise.pasantia.pokeapi.model.Item;
import com.bewise.pasantia.pokeapi.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    public List<Item> obtenerTodosLosItem(){
        return itemRepository.findAll();
    }

    public Item crearNuevoItem(ItemRequestDto itemRequestDto){
        Item nuevoItem = itemRequestDto.convert();
        return itemRepository.save(nuevoItem);
    }

    public Item borrarItem(Item item){
        itemRepository.delete(item);
        return item;
    }

    public Optional<Item> buscarPorId(int id){
       return itemRepository.findById(id);
    }

    public Item actualizar(Item item){
        return itemRepository.save(item);
    }
}
