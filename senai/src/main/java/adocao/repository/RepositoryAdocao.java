package adocao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import adocao.models.ModelAdocao;

@Repository
public interface RepositoryAdocao extends JpaRepository<ModelAdocao, Integer> {

    List<ModelAdocao> findAllByPet_Id(Integer adotante);

    @Query("SELECT a FROM ModelAdocao a WHERE a.doador.id = :doador")
    List<ModelAdocao> findAllByDoadorId(Integer doador);

    List<ModelAdocao> findAllByAdotante_Id(Integer pet);
    //@Query("SELECT a FROM ModelAdocao a WHERE a.pet.id = :pet")
    


}
