package adocao.dtos;

import java.time.LocalDateTime;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoadorDTO {
    
    private Integer id;

 
    private String nome;

    
    private String cpf;


    private String telefone;


    private String email;


    private LocalDateTime dt_registro;


    private LocalDateTime dt_update;


    private java.sql.Date dt_nasciemnto;
    
    
    private Integer fk_login;

}
