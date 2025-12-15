package adocao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import adocao.models.ModelDoador;

@Repository
public interface RepositoryDoador extends JpaRepository<ModelDoador, Integer> {
    List<ModelDoador> findPetsByDoador_Id(Integer id);
}
