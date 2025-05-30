package br.com.fiap.dao;

import br.com.fiap.entity.Cliente;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;
import java.util.Objects;

public class ClienteDAO implements IClienteDAO{

    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void cadastrar(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void atualizar(Cliente cliente){
        buscarPorId(cliente.getId()); //valida se existe
        em.merge(cliente);
    }

    @Override
    public void remover(Integer id){
        Cliente cliente = buscarPorId(id);
        em.remove(cliente);
    }

    @Override
    public Cliente buscarPorId(Integer id) throws IdNaoEncontradoException {
        Cliente cliente = em.find(Cliente.class, id);
        if (Objects.isNull(cliente)) {
            throw new IdNaoEncontradoException("Cliente não encontrado!");
        }
        return cliente;
    }

    @Override
    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }
}
