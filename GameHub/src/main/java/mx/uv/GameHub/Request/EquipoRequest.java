package mx.uv.GameHub.Request;

//Se crea una clase inmutable que representa una solicitud para crear o actualizar un equipo
public record EquipoRequest(
    Long dispositivo,
    String nombre,
    String marca,
    String estado,
    String condicion,
    String categoriaId
){
    
}
