package br.com.tranquilotech.Aula07.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TB_ITEM_TESTE")
@AllArgsConstructor
@NoArgsConstructor
public class ItemTeste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_item_teste", nullable = false)
    private Integer codigoItemTeste;
    @Column(name = "des_item_teste", nullable = false)
    private String descricaoItemTeste;

    @ManyToOne
    @JoinColumn(name = "cod_caso_teste")
    private CasoTeste casoTeste;

    @ManyToMany
    private List<Usuario> usuario;
}
