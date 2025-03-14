package br.com.fiap.view;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteCadastro {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Pietro", LocalDate.of(2010, 5, 30), BigDecimal.valueOf(20000000),
                "51333222313", Genero.MASCULINO);

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("CLIENTE_ORACLE");

        EntityManager em = entityManagerFactory.createEntityManager();

        em.persist(cliente);

        em.getTransaction().begin();
        em.getTransaction().commit();

        System.out.println("Cliente cadastrado");
    }
}
