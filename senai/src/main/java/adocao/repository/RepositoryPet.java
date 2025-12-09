package adocao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import adocao.models.ModelPet;

@Repository
public interface RepositoryPet extends JpaRepository<ModelPet, Integer>{

    @Query("SELECT p FROM ModelPet p" + 
        "WHERE (:especie IS NULL OR LOWER(p.especie) LIKE LOWER(CONCAT('%', :especie, '%'))" +
        "AND (:idade IS NULL  OR p.idade = :idade)" +
        "AND (:porte  IS NULL  OR p.porte = :porte)" +
        "AND (:condicao IS NULL  OR p.condicao = :condicao)" 
    )
    List<ModelPet> findByfiltro(@Param("especie") String especie,
                                @Param("idade") Integer idade,
                                @Param("porte") String porte,
                                @Param("condicao") String condicao );
                                
    List<ModelPet> findAllByDisponivel(boolean Disponivel);

}
