package br.com.fiap.model;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.annotation.Tabela;

@Tabela(nome = "TB_PESSOA")
public class Pessoa {
    @Coluna(nome = "nome_pessoa", obrigatorio = true, tamanho = 100)
    private String nome;

    @Coluna(nome = "idade_pessoa", obrigatorio = true)
    private Integer idade;

    @Coluna(nome = "altura_pessoa")
    private Double altura;

    public void andar() {
        System.out.println("Pessoa andando");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }
}
