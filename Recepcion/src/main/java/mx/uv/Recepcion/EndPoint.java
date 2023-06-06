package mx.uv.Recepcion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.recepcion.HistorialResponse;
import https.t4is_uv_mx.recepcion.ModificarRequest;
import https.t4is_uv_mx.recepcion.ModificarResponse;

@Endpoint
public class EndPoint {
    
    @Autowired
    private IEquipo iEquipo;

    
    @PayloadRoot (localPart="ModificarRequest", namespace="https://t4is.uv.mx/recepcion")
    @ResponsePayload
    public ModificarResponse Modificar(@RequestPayload ModificarRequest dispositivo, @RequestPayload ModificarRequest peticion){
    ModificarResponse respuesta = new ModificarResponse();
    
    List<Equipo> equipos = new ArrayList<>();
    iEquipo.findAll().forEach(equipos::add);

    for (Equipo equipo : equipos) {
        if(equipo.getDispositivo()==dispositivo.getDispositivo()){
            equipo.setEstado(peticion.getEstado());
            iEquipo.save(equipo);
            respuesta.setRespuesta("¡Dispositivo modificado!");
            return respuesta;
         }
    }

    return respuesta;
    }



    @PayloadRoot (localPart="HistorialRequest", namespace="https://t4is.uv.mx/recepcion")
    @ResponsePayload
    public HistorialResponse  Historial(){

        HistorialResponse respuesta = new HistorialResponse();

        List<Equipo> saludos = new ArrayList<>();

        iEquipo.findAll().forEach(saludos::add);

        List<String> temp = new ArrayList<>();
        String tempo = new String();

        for (Equipo saludador : saludos) {

            tempo ="| "+ saludador.getDispositivo()+ " | |" + saludador.getNombre()+" | "+"| "+ saludador.getMarca()+ " | "+"|"+saludador.getEstado()+" | "+"|"+saludador.getCondicion();

            temp.add(tempo);
        }
        respuesta.getRespuesta().addAll(temp);
        return respuesta;

        }
    }
