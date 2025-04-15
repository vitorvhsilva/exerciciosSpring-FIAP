package br.com.tranquilotech.Aula06.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_LIVRO")
public class Livro {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cd_livro")
    private Integer codigoLivro;

    @Column(name = "nr_pagina", length = 5)
    private Integer numeroPagina;

    @Column(name = "ds_titulo", length = 50)
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "codigoEditora")
    private Editora editora;

    @ManyToMany
    @JoinTable(name="TB_LIVRO_BIBLIOTECA",
            joinColumns=@JoinColumn(name="codigoLivro"),
            inverseJoinColumns=@JoinColumn(name="codigoBiblioteca"))
    private List<Biblioteca> bibliotecas;
}
