package br.com.fiap.dao;

import br.com.fiap.annotation.Tabela;

public class JpaDAO {

    public void pesquisar(Object object) {
        // recuperar a anotação @tabela
        Tabela anotacao = object.getClass().getAnnotation(Tabela.class);
        System.out.println("SELECT * FROM " + anotacao.nome());
    }
}
