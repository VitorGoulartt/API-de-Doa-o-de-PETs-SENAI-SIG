package adocao.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column
    private ModelPet petId;

    @OneToMany
    @Column
    private ModelAdotante adotanteId;
    
    @Column
    private String dataAdocao;

    @Column
    private String observacoes;

   
}
