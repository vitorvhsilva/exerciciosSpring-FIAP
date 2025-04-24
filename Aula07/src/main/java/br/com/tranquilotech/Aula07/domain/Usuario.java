package br.com.tranquilotech.Aula07.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_usuario", nullable = false)
    private Integer codigoUsuario;
    @Column(name = "nom_usuario", nullable = false)
    private String nomeUsuario;

    @ManyToMany
    @JoinTable(name = "TB_ITEM_TESTE_USUARIO",
        joinColumns = @JoinColumn(name = "cod_usuario"),
        inverseJoinColumns = @JoinColumn(name = "cod_item_teste")
    )
    private List<ItemTeste> itemsTeste;
}
