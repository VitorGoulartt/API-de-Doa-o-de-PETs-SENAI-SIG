package adocao.dtos;

import java.time.LocalDateTime;

import adocao.enums.Disponibilidade;
import adocao.enums.Porte;
import adocao.enums.Sexo;

import adocao.models.ModelEspecie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {

    private Integer id;

    private String nome;

    private ModelEspecie especie;

    private String raca;

    private int idade;

    private Sexo sexo;

    private Disponibilidade disponibilidade;

    private String fotos;

    private String cor;

    private Porte porte;
    
    private String descricao;

    private Boolean vacinas;

    private String  qtd_doses;

    private LocalDateTime dt_registro;

    private String castrado;




}
