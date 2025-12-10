package adocao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import adocao.models.ModelEspecie;

@Repository
public interface RepositoryEspecie extends JpaRepository<ModelEspecie, Integer> {

}
