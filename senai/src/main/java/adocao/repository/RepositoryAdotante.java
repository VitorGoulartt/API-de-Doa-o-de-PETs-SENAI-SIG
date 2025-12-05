package adocao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import adocao.models.ModelAdotante;

@Repository
public interface RepositoryAdotante extends JpaRepository<ModelAdotante, Integer>{

}
