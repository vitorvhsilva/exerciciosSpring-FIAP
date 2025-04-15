package br.com.tranquilotech.Aula06.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_endereco")
    private Integer codigoEndereco;

    @Column(name = "ds_logradouro", length = 100)
    private String logradouro;

    @Column(name = "nr_cep", length = 9)
    private String cep;

    @OneToOne(mappedBy = "codigoBiblioteca")
    private Biblioteca biblioteca;
}
