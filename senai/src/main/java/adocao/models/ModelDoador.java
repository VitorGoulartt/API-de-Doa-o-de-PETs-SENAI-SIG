package adocao.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "doadores")
@Entity
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

    @Column
    private Model

}
