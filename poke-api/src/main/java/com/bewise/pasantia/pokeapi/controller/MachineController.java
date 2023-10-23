package com.bewise.pasantia.pokeapi.controller;

import com.bewise.pasantia.pokeapi.app.MachineService;
import com.bewise.pasantia.pokeapi.dto.MachineRequestDto;
import com.bewise.pasantia.pokeapi.model.Machine;
import com.bewise.pasantia.pokeapi.repository.MachineRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/machine")
public class MachineController {
    private MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }
    @PostMapping
    public Machine crearNuevaMachine(@RequestBody MachineRequestDto machineRequestDto){
        return machineService.crearMachine(machineRequestDto);
    }

    @GetMapping
    public List<Machine> obtenerTodasLasMachine(){
        return machineService.obtenerTodasLasMachine();
    }

    @PutMapping("/{id}")
    private Machine actualizar(@PathVariable int id, MachineRequestDto machineRequestDto){
        Optional<Machine> machine = machineService.buscarPorId(id);
        if(machine.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra la machine");
        }
        Machine machineNueva = machineRequestDto.convert();
        return machineService.actualizar(machine.get());
    }

    @PatchMapping("/{id}")
    private Machine actualizarParcialmente(@PathVariable int id, MachineRequestDto machineRequestDto) {
        Optional<Machine> machine = machineService.buscarPorId(id);
        if (machine.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra la machine");
        }
        Machine machineNueva = machineRequestDto.partialConvert(machine.get());
      return machineService.actualizar(machineNueva);

    }

    @DeleteMapping("/{id}")
    private Machine borrarPorId(@PathVariable int id){
        Optional<Machine> machine = machineService.buscarPorId(id);
        if(machine.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra la machine");
        }
      return machineService.borrarMachine(machine.get());
    }
}
