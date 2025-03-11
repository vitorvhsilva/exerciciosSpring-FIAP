package br.com.fiap.dao;

import br.com.fiap.entity.Cliente;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;

public interface IClienteDAO {
    void cadastrar(Cliente cliente);
    void atualizar(Cliente cliente);
    void remover(Integer id) ;
    Cliente buscarPorId(Integer id) throws IdNaoEncontradoException;
    void commit() throws CommitException;
}
