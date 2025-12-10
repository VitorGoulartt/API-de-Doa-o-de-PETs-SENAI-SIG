package adocao.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "doadores")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModelDoador {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column 
    private String cpf;

    @Column
    private String telefone;

    @Column
    private String email;

    @Column
    private LocalDateTime dt_registro;

    @Column
    private LocalDateTime dt_update;

    @Column
    private String dt_nasciemnto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_login", nullable = false)
    private ModelLogin fk_login;

    

}
