package com.bewise.pasantia.pokeapi.app;

import com.bewise.pasantia.pokeapi.dto.MachineRequestDto;
import com.bewise.pasantia.pokeapi.model.Machine;
import com.bewise.pasantia.pokeapi.repository.MachineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    private MachineRepository machineRepository;

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public List<Machine> obtenerTodasLasMachine(){
        return machineRepository.findAll();
    }

    public Machine crearMachine(MachineRequestDto machineRequestDto){
        Machine nuevaMachine = machineRequestDto.convert();
        return machineRepository.save(nuevaMachine);
    }
    public Machine borrarMachine(Machine machine){
        machineRepository.delete(machine);
        return machine;
    }

    public Machine actualizar(Machine machine){
        return machineRepository.save(machine);
    }

    public Optional<Machine> buscarPorId(int id){
        return machineRepository.findById(id);
    }
}
