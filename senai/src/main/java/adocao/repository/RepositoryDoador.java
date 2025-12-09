package adocao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import adocao.models.ModelDoador;

@Repository
public interface RepositoryDoador extends JpaRepository<ModelDoador, Integer> {

}
