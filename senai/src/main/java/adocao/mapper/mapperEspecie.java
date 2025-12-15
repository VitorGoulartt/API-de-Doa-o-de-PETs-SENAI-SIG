package adocao.mapper;

import org.springframework.stereotype.Component;

import adocao.dtos.EspecieDTO;
import adocao.models.ModelEspecie;

@Component
public class mapperEspecie {

    public EspecieDTO toDto(ModelEspecie especie){
        return new EspecieDTO(
            especie.getId(),
            especie.getNome_especie()
        );
    }

}
