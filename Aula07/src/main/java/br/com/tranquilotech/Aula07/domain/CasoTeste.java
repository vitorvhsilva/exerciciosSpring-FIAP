package br.com.tranquilotech.Aula07.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_CASO_TESTE")
public class CasoTeste {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_caso_teste", nullable = false)
    private Integer codigoCasoTeste;
    @Column(name = "nom_caso_teste", nullable = false)
    private String nomeCasoTeste;
    @Column(name = "des_caso_teste", nullable = false)
    private String descricaoCasoTeste;
    @ManyToOne
    @JoinColumn(name = "cod_sistema")
    private Sistema sistema;
    @OneToMany(mappedBy = "casoTeste")
    private List<ItemTeste> itemsTeste;
}
