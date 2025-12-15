package adocao.mapper;

import org.springframework.stereotype.Component;

import adocao.dtos.PetDTO;
import adocao.models.ModelPet;

@Component
public class mapperPet {
     public PetDTO toDto(ModelPet pet) {
       
        return new PetDTO(
            pet.getId(),
            pet.getNome(),
            pet.getEspecie(),
            pet.getRaca(),
            pet.getIdade(),
            pet.getSexo(),
            pet.getDisponibilidade(),
            pet.getFotos(),
            pet.getCor(),
            pet.getPorte(),
            pet.getDescricao(),
            pet.getVacinas(),
            pet.getQtd_doses(),
            pet.getDt_registro(),
            pet.getCastrado()
    

        );
    }

}
