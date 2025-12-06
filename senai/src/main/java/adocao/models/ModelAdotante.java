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
@Table(name = "adotantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ModelAdotante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String telefone;

    @Column
    private String endereco;

    @Column
    private String email;

    @OneToMany
    private ModelPet petAdotados;

}
