package adocao.mapper;

import org.springframework.stereotype.Component;

import adocao.dtos.DoadorDTO;
import adocao.models.ModelDoador;

@Component
public class mapperDoador {

    public DoadorDTO toDto(ModelDoador doador){
        return new DoadorDTO(

            doador.getId(),
            doador.getNome(),
            doador.getCpf(),
            doador.getTelefone(),
            doador.getEmail(),
            doador.getDt_registro(),
            doador.getDt_update(),
            doador.getDt_nascimento()
            
        );
    }

}
