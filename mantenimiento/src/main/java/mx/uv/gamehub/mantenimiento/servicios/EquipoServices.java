package mx.uv.gamehub.mantenimiento.servicios;

import mx.uv.gamehub.mantenimiento.models.EquipoModel;
import mx.uv.gamehub.mantenimiento.repositorios.IEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EquipoServices {

    @Autowired
    IEquipoRepository equipoRepository;

    public ArrayList<EquipoModel> getEquipos(){
        return (ArrayList<EquipoModel>) equipoRepository.findAll();
    }

    public EquipoModel saveEquipo(EquipoModel equipo){
        return equipoRepository.save(equipo);
    }

    public Optional<EquipoModel> getById(Long id){
        return equipoRepository.findById(id);
    }

    public EquipoModel updateById(EquipoModel request, Long id){
        EquipoModel equipo = equipoRepository.findById(id).get();

        equipo.setEstado(request.getEstado());
        equipo.setCondicion(request.getCondicion());
        equipoRepository.save(equipo);
        return equipo;
    }
}
