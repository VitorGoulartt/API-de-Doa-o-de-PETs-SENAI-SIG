package adocao.models;

import java.time.LocalDateTime;



import adocao.enums.Disponibilidade;
import adocao.enums.Porte;
import adocao.enums.Sexo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModelPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @ManyToOne
    @JoinColumn(name = "nome_especie", referencedColumnName = "id")
    private ModelEspecie especie;

    @Column
    private String raca;

    @Column
    private int idade;
    
    @Column
     @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column
     @Enumerated(EnumType.STRING)
    private Disponibilidade disponibilidade;

    @Column
    private String fotos;

    @Column
    private String cor;

    @Column
     @Enumerated(EnumType.STRING)
    private Porte porte;

    @Column
    private String descricao;

    @Column
    private Boolean vacinas;

    @Column
    private String qtd_doses;

    @Column
    private LocalDateTime dt_registro;

    @Column
    private String castrado;

    @ManyToOne
    @JoinColumn(name = "doador_id")
    private ModelDoador doador;

    

    @PrePersist
    protected void onCreate() {
      dt_registro = LocalDateTime.now();
        
    }
    
 
   
    
}
