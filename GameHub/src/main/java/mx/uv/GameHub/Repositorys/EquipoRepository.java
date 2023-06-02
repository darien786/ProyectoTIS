package mx.uv.GameHub.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uv.GameHub.Entitys.Equipo;


//Es una interfaz de Spring Data JPA para proporcionar metodos para realizar operaciones de acceso a datos de la entidad Equipo
public interface EquipoRepository extends JpaRepository<Equipo, Long>{
    
}
