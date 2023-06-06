package mx.uv.gamehub.mantenimiento.models;

import javax.persistence.*;


@Entity
@Table(name="equipo")
public class EquipoModel {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Long dispositivo;
    
    @Column
    private String nombre;
    
    @Column
    private String marca;
    
    @Column
    private String estado;
    
    @Column
    private String condicion;
    
    @Column
    private String categoria_nombre;

    public Long getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Long dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getCategoria() {
        return categoria_nombre;
    }

    public void setCategoria(String categoria_nombre) {
        this.categoria_nombre = categoria_nombre;
    }
}
