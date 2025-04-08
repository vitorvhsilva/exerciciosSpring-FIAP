package br.com.tranquilotech.aula05.dao;

import br.com.tranquilotech.aula05.entity.Investimento;
import br.com.tranquilotech.aula05.exception.CommitException;
import br.com.tranquilotech.aula05.exception.IdNaoEncontradoException;
import jakarta.persistence.EntityManager;

public class InvestimentoDaoImpl extends GenericDaoImpl<Investimento, Integer> implements InvestimentoDao{

    public InvestimentoDaoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Investimento salvar(Investimento entity) {
        return em.merge(entity);
    }

    @Override
    public void remover(Integer id) throws IdNaoEncontradoException {
        Investimento entidade = buscar(id);
        em.remove(entidade);
    }

    @Override
    public Investimento buscar(Integer id) throws IdNaoEncontradoException {
        Investimento entidade = em.find(clazz, id);
        if (entidade == null) {
            throw new IdNaoEncontradoException("Entidade nao encontrada");
        }
        return entidade;
    }

    @Override
    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }
}
