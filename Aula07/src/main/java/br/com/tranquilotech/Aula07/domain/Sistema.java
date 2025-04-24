package br.com.tranquilotech.Aula07.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TB_SISTEMA")
@AllArgsConstructor
@NoArgsConstructor
public class Sistema {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_sistema", nullable = false)
    private Integer codigoSistema;
    @Column(name = "nom_sistema", nullable = false)
    private String nomeSistema;

    @OneToMany(mappedBy = "sistema")
    private List<CasoTeste> casosTestes;
}
