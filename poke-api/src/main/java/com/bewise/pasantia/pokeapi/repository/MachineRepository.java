package com.bewise.pasantia.pokeapi.repository;

import com.bewise.pasantia.pokeapi.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer> {
}
