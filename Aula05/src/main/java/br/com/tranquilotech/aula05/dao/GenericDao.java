package br.com.tranquilotech.aula05.dao;

import br.com.tranquilotech.aula05.exception.CommitException;
import br.com.tranquilotech.aula05.exception.IdNaoEncontradoException;

public interface GenericDao<T, K> {
    T salvar(T entity);
    void remover(K id) throws IdNaoEncontradoException;
    T buscar(K id) throws IdNaoEncontradoException;
    void commit() throws CommitException;
}
