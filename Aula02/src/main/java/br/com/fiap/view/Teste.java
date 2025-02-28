package br.com.fiap.view;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.model.Pessoa;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Teste {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();

        String nomeClasse = pessoa.getClass().getName();
        System.out.println(nomeClasse);

        Method[] metodos = pessoa.getClass().getDeclaredMethods();

        for (Method m: metodos) {
            System.out.println(m.getName());
        }

        Field[] atributos = pessoa.getClass().getDeclaredFields();

        for (Field f: atributos) {
            Coluna anotacao = f.getAnnotation(Coluna.class);
            System.out.println(f);
            System.out.println(anotacao.nome() + " " + anotacao.tamanho()
                    + " " + anotacao.obrigatorio());
        }
    }
}
