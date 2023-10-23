package com.bewise.pasantia.pokeapi.repository;

import com.bewise.pasantia.pokeapi.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer>{


}
