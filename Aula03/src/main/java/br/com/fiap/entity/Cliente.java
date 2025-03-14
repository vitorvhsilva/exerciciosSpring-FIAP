package br.com.fiap.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
public class Cliente {
    @Id @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
    private Integer id;

    @Column(name = "nome_cliente", nullable = false, length = 100)
    private String nome;

    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    private LocalDate dataNascimento;

    @Column(name = "dt_criacao", updatable = false)
    @Temporal(TemporalType.DATE) @CreationTimestamp //criar a data automaticamente no cadastro
    private LocalDate dataCriacao;

    @Column(name = "vl_credito")
    private BigDecimal credito;

    @Column(name = "nr_cpf", nullable = false, length = 11)
    private String cpf;

    @Transient
    private Integer idade;

    @Column(name = "fl_foto") @Lob // long object
    private byte[] foto;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_genero", length = 20)
    private Genero genero;

    public Cliente() {
    }

    public Cliente(String nome, LocalDate dataNascimento, BigDecimal credito, String cpf, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.credito = credito;
        this.cpf = cpf;
        this.genero = genero;
    }

    @PostPersist
    private void executar() {
        System.out.println("Executando o método...");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
