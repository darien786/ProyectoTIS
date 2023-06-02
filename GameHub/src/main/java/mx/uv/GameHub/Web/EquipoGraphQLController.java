package mx.uv.GameHub.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import mx.uv.GameHub.Entitys.Categoria;
import mx.uv.GameHub.Entitys.Equipo;
import mx.uv.GameHub.Repositorys.CategoriaRepository;
import mx.uv.GameHub.Repositorys.EquipoRepository;
import mx.uv.GameHub.Request.EquipoRequest;

@Controller
public class EquipoGraphQLController {
        
    //Para agregar automaticamente instancias
    @Autowired
    private EquipoRepository equipoRepository;

    //Para agregar automaticamente instancias
    @Autowired 
    private CategoriaRepository categoriaRepository;

    //Para manejar las operaciones de consulta(queries) en GraphQL
    @QueryMapping
    //Este metodo es para obtener todos los equipos
    public List<Equipo> listarEquipos(){
        return equipoRepository.findAll();
    }

    //Este metodo es para buscar un equipo por su ID
    //La anotacion @Argument se utiliza para indicar que un parametro de metodo se debe asignar
    @QueryMapping
    public Equipo buscarEquipoPorId(@Argument Long id){
        return equipoRepository.findById(id).orElseThrow(
            ()-> new RuntimeException(String.format("Producto %s no encontrado",id )));    
    }
    
    //Este metodo es para obtener todas las categorias
    @QueryMapping
    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }
    
    //Este metodo es para buscar una Categoria por su ID
    @QueryMapping
    public Categoria buscarCategoriaPorId(@Argument String id){
        return categoriaRepository.findById(id).orElseThrow(
            ()-> new RuntimeException(String.format("Producto %s no encontrado",id)));
    }
    
    //Se utiliza para mapear metodos que manejan operaciones de mutacion en GraphQL
    @MutationMapping
    //Este metodo es para crear un nuevo equipo
    public Equipo crearEquipo(@Argument EquipoRequest equipoRequest){
        Categoria categoria = categoriaRepository.findById(equipoRequest.categoriaId()).orElse(null);
        Equipo equipoNew = new Equipo();
        equipoNew.setNombre(equipoRequest.nombre());
        equipoNew.setMarca(equipoRequest.marca());
        equipoNew.setEstado(equipoRequest.estado());
        equipoNew.setCondicion(equipoRequest.condicion());
        equipoNew.setCategoria(categoria);
        
        //Para guardar los datos
        return equipoRepository.save(equipoNew);
    }

    //Este metodo es para actualizar los datos de un equipo con el ID
    @MutationMapping
    public Equipo actualizarEquipo(@Argument Long id, @Argument EquipoRequest equipoRequest){
        Categoria categoria = categoriaRepository.findById(equipoRequest.categoriaId()).orElse(null);
        Equipo equipoNew = new Equipo();
        equipoNew.setDispositivo(id);
        equipoNew.setNombre(equipoRequest.nombre());
        equipoNew.setMarca(equipoRequest.marca());
        equipoNew.setEstado(equipoRequest.estado());
        equipoNew.setCondicion(equipoRequest.condicion());
        equipoNew.setCategoria(categoria);
        
        //Se guardan los datos agregados al equipo
        return equipoRepository.save(equipoNew);
    }

    //Este metodo es para eliminar un equipo por su ID
    @MutationMapping
    public void eliminarEquipo(@Argument Long id){
        equipoRepository.deleteById(id);
    }
}
