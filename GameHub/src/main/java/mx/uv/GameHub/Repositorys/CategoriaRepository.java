package mx.uv.GameHub.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uv.GameHub.Entitys.Categoria;

//Es una interfaz de Spring Data JPA para proporcionar metodos para realizar operaciones de acceso a datos de la entidad Categoria
public interface CategoriaRepository extends JpaRepository<Categoria, String>{
    
}
