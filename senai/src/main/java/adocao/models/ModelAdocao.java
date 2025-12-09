package adocao.models;

import adocao.enums.StatusAdocao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "adocoes")
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModelAdocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    @OneToMany
    @Column()
    private ModelPet fk_pet;

    @OneToMany
    @Column
    private ModelAdotante fk_adotante; 

    @OneToMany
    @Column
    private  ModelDoador fk_doador;
    
    @Column
    private String dt_adocao;

    @Column
    private String OBSERVACOES;

    @Column
    private String motivo_adotante;

    @Column
    private String motivo_doador;

    @Column(name = "status_adocao", nullable = true)
    @Enumerated(EnumType.STRING)
    private StatusAdocao StatusAdocao;

   
}
