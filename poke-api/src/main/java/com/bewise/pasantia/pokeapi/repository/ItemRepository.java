package com.bewise.pasantia.pokeapi.repository;

import com.bewise.pasantia.pokeapi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
