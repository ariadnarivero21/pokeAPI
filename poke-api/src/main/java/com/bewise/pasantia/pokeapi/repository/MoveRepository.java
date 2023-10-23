package com.bewise.pasantia.pokeapi.repository;

import com.bewise.pasantia.pokeapi.model.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveRepository extends JpaRepository<Move, Integer> {

}
