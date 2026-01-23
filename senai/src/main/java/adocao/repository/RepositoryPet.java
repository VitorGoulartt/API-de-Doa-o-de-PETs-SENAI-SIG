package adocao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import adocao.enums.Disponibilidade;
import adocao.enums.Porte;
import adocao.enums.Sexo;
import adocao.models.ModelPet;

@Repository
public interface RepositoryPet extends JpaRepository<ModelPet, Integer>{

  @Query("SELECT p FROM ModelPet p WHERE " +
           "(:sexo IS NULL OR p.sexo = :sexo) AND " +
           "(:vacinas IS NULL OR p.vacinas = :vacinas) AND " +
           "(:cor IS NULL OR p.cor LIKE CONCAT('%', :cor, '%')) AND " +
           "(:porte IS NULL OR p.porte = :porte)")
    List<ModelPet> filtrarPets(@Param("cor") String cor,
                                @Param("sexo") Sexo sexo,
                                @Param("porte") Porte porte, 
                                @Param("vacinas") String vacinas );
                                
    List<ModelPet> findAllByDisponibilidade(Disponibilidade Disponibilidade);

    List<ModelPet> findPetsByDoador_Id(Integer Id);

}
