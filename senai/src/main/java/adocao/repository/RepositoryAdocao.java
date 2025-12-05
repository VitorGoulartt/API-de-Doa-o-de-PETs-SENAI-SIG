package adocao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import adocao.models.ModelAdocao;

@Repository
public interface RepositoryAdocao extends JpaRepository<ModelAdocao, Integer> {

}
