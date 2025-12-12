package adocao.dtos;

import adocao.enums.StatusAdocao;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdocaoDTO {
    
    private Integer id; 

    private Integer fk_adotante;

    private Integer fk_doador;

    private Integer fk_pet;
    
    
    private String dt_adocao;

    
    private String OBSERVACOES;

    
    private String motivo_adotante;

    
    private String motivo_doador;


    private StatusAdocao StatusAdocao;

    

}
