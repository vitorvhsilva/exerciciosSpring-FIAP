package br.com.tranquilotech.aula05.dao;

import br.com.tranquilotech.aula05.exception.CommitException;
import br.com.tranquilotech.aula05.exception.IdNaoEncontradoException;
import jakarta.persistence.EntityManager;

import java.lang.reflect.ParameterizedType;

public abstract class GenericDaoImpl<T, K> implements GenericDao<T, K> {
    protected EntityManager em;
    protected Class<T> clazz;

    public GenericDaoImpl(EntityManager em) {
        this.em = em;
        //Obter em tempo de execucao o .class da Entidade
        this.clazz = (Class<T>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T salvar(T entidade) {
        return em.merge(entidade);
    }

    public void remover(K id) throws IdNaoEncontradoException {
        T entidade = buscar(id);
        em.remove(entidade);
    }

    public T buscar(K id) throws IdNaoEncontradoException {
        T entidade = em.find(clazz, id);
        if (entidade == null) {
            throw new IdNaoEncontradoException("Entidade nao encontrada");
        }
        return entidade;
    }

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
