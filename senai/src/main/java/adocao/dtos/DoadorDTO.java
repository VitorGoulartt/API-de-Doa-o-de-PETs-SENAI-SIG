package adocao.dtos;



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


    private java.sql.Date  dt_registro;


    private java.sql.Date  dt_update;


    private java.sql.Date dt_nascimento;
    
    
   

}
