package com.bewise.pasantia.pokeapi.controller;

import com.bewise.pasantia.pokeapi.app.MoveService;
import com.bewise.pasantia.pokeapi.model.Move;
import com.bewise.pasantia.pokeapi.repository.PokemonRepository;
import com.bewise.pasantia.pokeapi.app.PokemonService;
import com.bewise.pasantia.pokeapi.dto.PokemonRequestDto;
import com.bewise.pasantia.pokeapi.model.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final MoveService moveService;
    private final PokemonService pokemonService;
    public PokemonController(PokemonService pokemonService, MoveService moveService) {
        this.pokemonService = pokemonService;
        this.moveService = moveService;
    }

    @PostMapping
    public Pokemon crear(@RequestBody PokemonRequestDto pokemonRequestDto){
        List<Move> moves = new ArrayList<>();
        List<Integer> movesId = pokemonRequestDto.getMovesId();
        for(Integer id : movesId){
           Optional<Move> idMove = moveService.buscarPorId(id);
           if(idMove.isEmpty()){
               throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el move");
           }
           moves.add(idMove.get());
        }
        return pokemonService.crearPokemon(pokemonRequestDto, moves);

    }
    @GetMapping
    public List<Pokemon> obtenerTodos(){
       return pokemonService.obtenerTodosLosPokemon();
    }

    @GetMapping("/{id}")
    public Pokemon buscarPorId(@PathVariable int id){
        Optional<Pokemon> pokemon = pokemonService.buscarPorId(id);
        if(pokemon.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el pokemon");
        }
        return  pokemon.get();
    }

    @PutMapping("/{id}")
    private Pokemon actualizar(@RequestBody PokemonRequestDto pokemonRequestDto, @PathVariable int id){
        Optional<Pokemon> pokemon = pokemonService.buscarPorId(id);
        if(pokemon.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el pokemon");
        }
        Pokemon pokemonNuevo = pokemonRequestDto.convert(pokemon.get());
        return pokemonService.actualizar(pokemonNuevo);
    }
    @PatchMapping("/{id}")
    private Pokemon actualizarParcialmente(@RequestBody PokemonRequestDto pokemonRequestDto, @PathVariable int id) {
        Optional<Pokemon> pokemon = pokemonService.buscarPorId(id);
        if(pokemon.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el pokemon");
        }
        Pokemon pokemonNuevo = pokemonRequestDto.partialConvert(pokemon.get());
        return pokemonService.actualizar(pokemonNuevo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable int id){
        Optional<Pokemon> pokemon = pokemonService.buscarPorId(id);
        if(pokemon.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el pokemon");
        }
         pokemonService.borrarPokemon(pokemon.get());
        return ResponseEntity.ok("Pokemon con id "+id+" eliminado");
    }

}
