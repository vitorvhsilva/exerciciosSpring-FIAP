package br.com.tranquilotech.Aula06.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Editora {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_editora")
    private Integer codigoEditora;

    @Column(name = "nm_editora", length = 80)
    private String nomeEditora;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "codigoLivro")
    private List<Livro> livros;
}
