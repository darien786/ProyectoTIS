package mx.uv.gamehub.mantenimiento.models;

import javax.persistence.*;


@Entity
@Table(name="equipo")
public class EquipoModel {
    @Id
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
        dispositivo = dispositivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        estado = estado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        condicion = condicion;
    }

    public String getCategoria() {
        return categoria_nombre;
    }

    public void setCategoria(String categoria_nombre) {
        categoria_nombre = categoria_nombre;
    }
}
