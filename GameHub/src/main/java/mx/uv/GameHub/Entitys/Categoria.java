package mx.uv.GameHub.Entitys;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Categoria {

    //Atributo id que indica que es la llave primaria de la entidad
    @Id
    private String nombre;

    //Indica que existe una relacion de uno a muchos entre Categoria y Equipo 
    @OneToMany 

    //Especifica que la relació esta mapeada por el campo "categoria" en la entidad Equipo
    (mappedBy = "categoria")
    private List<Equipo> equipos;
    
}
