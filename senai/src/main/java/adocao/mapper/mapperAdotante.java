package adocao.mapper;

import org.springframework.stereotype.Component;

import adocao.dtos.AdotanteDTO;

import adocao.models.ModelAdotante;

@Component
public class mapperAdotante {

    public AdotanteDTO toDto(ModelAdotante adotante) {
       
        return new AdotanteDTO(
            adotante.getId(),
            adotante.getNome(),
            adotante.getTelefone(),
            adotante.getEmail()
            
            

        );
    }

    
}



