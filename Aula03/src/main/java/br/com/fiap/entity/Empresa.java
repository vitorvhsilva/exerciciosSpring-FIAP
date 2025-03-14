package br.com.fiap.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "TB_EMPRESA")
@SequenceGenerator(name = "empresa", sequenceName = "SQ_TB_EMPRESA", allocationSize = 1)
public class Empresa {
    @Id @Column(name = "id_empresa")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa")
    private Integer codigo;

    @Column(name = "nm_empresa", nullable = false, length = 100)
    private String nome;

    @Column(name = "dt_abertura") @Temporal(TemporalType.DATE)
    private LocalDate dataAbertura;

    @Column(name = "nr_cnpj", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "st_ativo", nullable = false)
    private Boolean ativo;

    @Column(name = "fl_logo") @Lob
    private byte[] logo;

    @Column(name = "ds_porte", length = 20) @Enumerated(EnumType.STRING)
    private Porte porte;

    @Column(name = "faturamento_empresa", nullable = false)
    private BigDecimal faturamento;

    @Transient
    private String token;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public BigDecimal getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(BigDecimal faturamento) {
        this.faturamento = faturamento;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
