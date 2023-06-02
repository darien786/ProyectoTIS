package mx.uv.gamehub.mantenimiento.controllers;


import mx.uv.gamehub.mantenimiento.models.EquipoModel;
import mx.uv.gamehub.mantenimiento.servicios.EquipoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/equipo")
public class EquipoController {

    @Autowired
    private EquipoServices equipoServices;

    @GetMapping
    public ArrayList<EquipoModel> getEquipo(){
        return this.equipoServices.getEquipos();
    }

    @PostMapping
    public EquipoModel saveEquipo(@RequestBody EquipoModel equipo){
        return this.equipoServices.saveEquipo(equipo);
    }

    @GetMapping(path = "/{dispositivo}")
    public Optional<EquipoModel> getEquipoById(@PathVariable Long id){
        return this.equipoServices.getById(id);
    }

    @PutMapping(path = "/{dispositivo}")
    public EquipoModel updateEquipoById(@RequestBody EquipoModel request,@PathVariable long id){
        return this.equipoServices.updateById(request, id);
    }
}
