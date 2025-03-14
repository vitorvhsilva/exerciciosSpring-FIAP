package br.com.fiap.view;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.IClienteDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteDAO {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("CLIENTE_ORACLE");

        EntityManager em = entityManagerFactory.createEntityManager();

        IClienteDAO dao = new ClienteDAO(em);

        //cadastrar um cliente
        try {
            dao.cadastrar(new Cliente("Vitor Hugo", LocalDate.of(2006, 3, 28), BigDecimal.valueOf(100),
                    "51333222312", Genero.MASCULINO));
            dao.commit();
            System.out.println("Cliente cadastrado");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        //pesquisar um cliente
        try {
            Cliente cliente = dao.buscarPorId(1);
            System.out.println(cliente.getNome());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        //atualizar um cliente
        try {
            Cliente cliente = dao.buscarPorId(1);
            cliente.setNome("Tranquilo Tech");
            cliente.setGenero(Genero.MASCULINO);
            dao.atualizar(cliente);
            dao.commit();
            System.out.println("Cliente atualizado!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        //remover um cliente
        try {
            dao.remover(1);
            dao.commit();
            System.out.println("Cliente removido!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
