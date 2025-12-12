package adocao.mapper;

import org.springframework.stereotype.Component;

import adocao.dtos.AdocaoDTO;
import adocao.models.ModelAdocao;

@Component
public class mapperAdocao {

    public AdocaoDTO toDto(ModelAdocao adocao) {
        // Lógica de conversão manual
        return new AdocaoDTO(
            adocao.getId(),
            adocao.getPet().getId(),
            adocao.getAdotante().getId(),
            adocao.getDoador().getId(),
            adocao.getDt_adocao(),
            adocao.getOBSERVACOES(),
            adocao.getMotivo_adotante(),
            adocao.getMotivo_doador(),
            adocao.getStatusAdocao()

        );
    }
}
