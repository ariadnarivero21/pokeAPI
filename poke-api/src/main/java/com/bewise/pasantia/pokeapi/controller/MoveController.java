package com.bewise.pasantia.pokeapi.controller;

import com.bewise.pasantia.pokeapi.app.MoveService;
import com.bewise.pasantia.pokeapi.dto.MoveRequestDto;
import com.bewise.pasantia.pokeapi.model.Move;
import com.bewise.pasantia.pokeapi.repository.MoveRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/move")
public class MoveController {
    private final MoveService moveService;

    public MoveController(MoveService moveService) {
        this.moveService = moveService;
    }

    @PostMapping
    public Move crear(@RequestBody MoveRequestDto moveRequestDto){
        return moveService.crearNuevoMove(moveRequestDto);
    }
    @GetMapping
    public List<Move> obtenerTodos() {
        return moveService.obtenerLosMove();
    }
    @PutMapping("/{id}")
    private Move actualizar(@RequestBody MoveRequestDto moveRequestDto, @PathVariable int id){
        Optional<Move> move = moveService.buscarPorId(id);
        if(move.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El move no se encuentra");
        }
        Move moveNuevo = moveRequestDto.convert();
        return moveService.actualizar(moveNuevo);
    }

    @PatchMapping("/{id}")
    private Move actualizarParcialmente(@RequestBody MoveRequestDto moveRequestDto, @PathVariable int id) {
        Optional<Move> move = moveService.buscarPorId(id);
        if (move.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El move no se encuentra");
        }
        Move moveNuevo = moveRequestDto.partialConvert(move.get());
        return moveService.actualizar(moveNuevo);
    }
    @DeleteMapping("/{id}")
    public void borrarPorId(@PathVariable int id){
        Optional<Move> move = moveService.buscarPorId(id);
            if(move.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El move no se encuentra");
            }
            moveService.borrarMove(move.get());
    }

}
