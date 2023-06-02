package mx.uv.GameHub.Entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Indica que la clase Categoria agregara como tabla en la base de datos
@Entity

//Genera un constructor con todos los argumentos
@AllArgsConstructor

//Genera un constructor sin argumentos
@NoArgsConstructor

//Es para generar automaticamente los metodos toString(), equals(), hasCode y los metodos getter y setter para todos los campos de la clase
@Data

//Para construir objetos utilizando el patron de diseño de Builder
@Builder

public class Equipo{
    //Indica que es la llave primaria de la entidad
    @Id
    //Se generara automaticamente 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long dispositivo;
    
    //Para representar el nombre del equipo
    private String nombre;
    
    //Para representar la marca del equipo
    private String marca;
    
    //Para representar el estado del equipo
    private String estado;
    
    //Para representar la condicion del equipo
    private String condicion;

    //Indica que existe una relación de muchos a uno entre Equipo y Categoria
    @ManyToOne
    private Categoria categoria;
}
