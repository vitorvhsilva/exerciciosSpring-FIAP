package br.com.tranquilotech.aula05.singleton;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactorySingleton {
    //1 - atribuyo estatico que armazena a unica instancia
    private static EntityManagerFactory unico;

    //2 - construtor privado
    private EntityManagerFactorySingleton() {}

    //3 - metodo estatico que cria e retorna a instancia
    public static EntityManagerFactory getInstance() {
        if (unico == null)
            unico = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        return unico;
    }
}
