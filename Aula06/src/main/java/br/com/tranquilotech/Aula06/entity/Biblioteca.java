package br.com.tranquilotech.Aula06.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TB_BIBLIOTECA")
public class Biblioteca {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_biblioteca")
    private Integer codigoBiblioteca;

    @Column(name = "nm_biblioteca", length = 80)
    private String nomeBiblioteca;

    @Column(name = "dt_abertura")
    private LocalDate dataAbertura;

    @Column(name = "dt_abertura")
    @OneToOne
    @JoinColumn(name = "codigoEndereco")
    private Endereco endereco;

    @ManyToMany
    @JoinTable(name="TB_LIVRO_BIBLIOTECA",
            joinColumns=@JoinColumn(name="codigoBiblioteca"),
            inverseJoinColumns=@JoinColumn(name="codigoLivro"))
    private List<Livro> livros;
}
