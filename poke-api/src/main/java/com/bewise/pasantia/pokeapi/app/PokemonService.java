package com.bewise.pasantia.pokeapi.app;

import com.bewise.pasantia.pokeapi.model.Move;
import com.bewise.pasantia.pokeapi.repository.PokemonRepository;
import com.bewise.pasantia.pokeapi.dto.PokemonRequestDto;
import com.bewise.pasantia.pokeapi.model.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> obtenerTodosLosPokemon(){
        return pokemonRepository.findAll();
    }

    public Pokemon crearPokemon(PokemonRequestDto pokemonRequestDto, List<Move> moves){
        Pokemon nuevoPokemon = pokemonRequestDto.convert();
        nuevoPokemon.setMovimientos(moves);
        return pokemonRepository.save(nuevoPokemon);
    }
    public Pokemon borrarPokemon(Pokemon pokemon){
        pokemonRepository.delete(pokemon);
        return pokemon;
    }

    public Pokemon actualizar(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }

    public Optional<Pokemon> buscarPorId(int id){
      return pokemonRepository.findById(id);
    }

}