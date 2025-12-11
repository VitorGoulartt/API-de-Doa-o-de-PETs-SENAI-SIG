package adocao.models;

import java.time.LocalDateTime;



import adocao.enums.Disponibilidade;
import adocao.enums.Porte;
import adocao.enums.Sexo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    private int id;

    @Column
    private String nome;

    @Column
    @ManyToMany
    private ModelEspecie especie;

    @Column
    private String raca;

    @Column
    private int idade;
    
    @Column
    private Sexo sexo;

    @Column
    private Disponibilidade disponibilidade;

    @Column
    private String fotos;

    @Column
    private String cor;

    @Column
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

    

    @PrePersist
    protected void onCreate() {
      dt_registro = LocalDateTime.now();
        
    }
    

   
    
}
