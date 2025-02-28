package br.com.fiap.model;

public class Professor extends Pessoa{
    @Override
    public void andar() {
        System.out.println("Professor andando");
    }
}
