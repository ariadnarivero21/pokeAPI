package com.bewise.pasantia.pokeapi.app;

import com.bewise.pasantia.pokeapi.dto.MoveRequestDto;
import com.bewise.pasantia.pokeapi.model.Move;
import com.bewise.pasantia.pokeapi.repository.MoveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoveService {

    private MoveRepository moveRepository;
    public MoveService(MoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }
    public List<Move> obtenerLosMove(){
        return moveRepository.findAll();
    }
    public Move crearNuevoMove(MoveRequestDto moveRequestDto){
        Move nuevoMove = moveRequestDto.convert();
        return moveRepository.save(nuevoMove);
    }

    public Move borrarMove(Move move){
        moveRepository.delete(move);
        return move;
    }

    public Move actualizar(Move move){
       return moveRepository.save(move);
    }

    public Optional<Move> buscarPorId(int id){
       return moveRepository.findById(id);
    }

}
