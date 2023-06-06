package mx.uv.Recepcion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipo {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long dispositivo;
    private String nombre;
	private String marca;
    private String estado;
    private String condicion;
    private String categoria;

    public void setDispositivo(Long dispositivo) {
        this.dispositivo = dispositivo;
    }
    
    public Long getDispositivo() {
        return dispositivo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setMarca(String marca) {
        this.marca=marca;
    }

    public String getMarca(){
        return marca;
    }

    public void setEstado(String estado) {
        this.estado=estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setCondicion(String condicion) {
        this.condicion=condicion;
    }

    public String getCondicion(){
        return condicion;
    }

    public void setCategoria(String categoria) {
        this.categoria=categoria;
    }

    public String getCategoria(){
        return categoria;
    }
    
}
