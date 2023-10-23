package com.bewise.pasantia.pokeapi.repository;

import com.bewise.pasantia.pokeapi.model.Fight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FightRepository extends JpaRepository<Fight, Integer>{
}
