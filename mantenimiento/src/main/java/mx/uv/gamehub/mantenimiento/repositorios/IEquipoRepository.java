package mx.uv.gamehub.mantenimiento.repositorios;

import mx.uv.gamehub.mantenimiento.models.EquipoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipoRepository extends JpaRepository<EquipoModel, Long> {

}
