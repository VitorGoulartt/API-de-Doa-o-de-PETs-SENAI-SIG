package adocao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import adocao.models.ModelAdocao;

@Repository
public interface RepositoryAdocao extends JpaRepository<ModelAdocao, Integer> {

    List<ModelAdocao> findAllByAdotanteId(Integer fk_adotante);


}
